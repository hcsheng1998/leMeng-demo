package com.nhsoft.ledemo.util;

import org.apache.commons.lang3.reflect.TypeUtils;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CopyUtil {

    private static final Logger LOG = LoggerFactory.getLogger(com.nhsoft.ledemo.util.CopyUtil.class);

    private static ThreadLocal<List<Object>> levelStack = ThreadLocal.withInitial(ArrayList::new);

    public static <K, V> K to(V v, Class<K> kClass) {
        if(v == null) {
            return null;
        }
        if(levelStack.get().contains(v)) {
            return null;
        }
        try {
            levelStack.get().add(v);
            Field[] fields = Hibernate.getClass(v).getDeclaredFields();

            K k = kClass.newInstance();
            Optional<Field> srcIdField = Arrays.stream(fields).filter(f -> f.getType().getName().endsWith("Id")).findFirst();
            Optional<Field> aimIdField = Arrays.stream(kClass.getDeclaredFields()).filter(f -> f.getType().getName().endsWith("Id")).findFirst();
            if(srcIdField.isPresent()) {
                srcIdField.get().setAccessible(true);
                Object srcIdObject = srcIdField.get().get(v);
                if(srcIdObject != null) {
                    if (aimIdField.isPresent()) {
                        aimIdField.get().setAccessible(true);
                        Class aimIdClass = aimIdField.get().getType();
                        Object aimId = aimIdClass.newInstance();
                        BeanUtils.copyProperties(srcIdObject, aimId);
                        aimIdField.get().set(k, aimId);
                    } else {
                        BeanUtils.copyProperties(srcIdObject, k);
                    }
                }
            } else {
                if(aimIdField.isPresent()) {
                    aimIdField.get().setAccessible(true);
                    Class aimIdClass = aimIdField.get().getType();
                    Object aimId = aimIdClass.newInstance();
                    BeanUtils.copyProperties(v, aimId);
                    aimIdField.get().set(k, aimId);
                }
            }
            List<String> aimFieldNames = Arrays.stream(k.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
            List<Field> fieldList = Arrays.stream(fields).filter(f -> Collection.class.isAssignableFrom(f.getType()) && aimFieldNames.contains(f.getName())).collect(Collectors.toList());
            List<Field> diffList = Arrays.stream(fields).filter(f -> {
                try {
                    return kClass.getDeclaredField(f.getName()).getType() != f.getType();
                } catch (Exception e) {
                    return false;
                }
            }).collect(Collectors.toList());

            if (fieldList != null && fieldList.size() > 0){
                for (int i = fieldList.size() - 1; i >= 0; i--) {
                    Field field = fieldList.get(i);
                    Type type = field.getGenericType();
                    if (type instanceof ParameterizedType) {
                        ParameterizedType pt = (ParameterizedType) type;
                        Class clz = (Class) pt.getActualTypeArguments()[0];//得到对象list中实例的类型
                        String nameClz = clz.getName();
                        if (nameClz.equals("java.lang.String") || nameClz.equals("java.lang.Integer")
                                || nameClz.equals("java.math.BigDecimal") || nameClz.equals("java.math.BigInteger")){
                            fieldList.remove(field);
                        }
                    }
                }
            }

            BeanUtils.copyProperties(v, k, Stream.concat(fieldList.stream(), diffList.stream()).map(Field::getName).toArray(String[]::new));
            for(Field field: diffList) {
                field.setAccessible(true);
                Field kField = k.getClass().getDeclaredField(field.getName());
                kField.setAccessible(true);
                if(!Hibernate.isInitialized(field.get(v))) {
                    continue;
                }

                Method method = null;
                try {
                    //取set方法
                    method = kClass.getMethod("set" + kField.getType().getSimpleName(), kField.getType());

                } catch (NoSuchMethodException e){

                }
                if(method != null){
                    method.invoke(k, to(field.get(v), kField.getType()));

                } else {
                    kField.set(k, to(field.get(v), kField.getType()));

                }
            }
            for(Field field: fieldList) {
                field.setAccessible(true);
                Field kField = k.getClass().getDeclaredField(field.getName());
                kField.setAccessible(true);
                if(!Hibernate.isInitialized(field.get(v))) {
                    continue;
                }
                Type paramType = ((ParameterizedType)kField.getGenericType()).getActualTypeArguments()[0];
                Class paramTypeClass = TypeUtils.getRawType(paramType, null);
                if(List.class.isAssignableFrom(kField.getType())) {
                    kField.set(k, toList((Collection)field.get(v), paramTypeClass));
                } else if(Set.class.isAssignableFrom(kField.getType())){
                    kField.set(k, toSet((Collection)field.get(v), paramTypeClass));
                }
            }
            return k;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            levelStack.get().remove(levelStack.get().size()-1);
        }
    }

    public static <K, V> List<K> toList(Collection<V> vList, Class<K> kClass) {
        if(vList == null) {
            return null;
        }
        return vList.stream().map(v -> to(v, kClass)).collect(Collectors.toList());
    }

    public static <K, V> Set<K> toSet(Collection<V> vList, Class<K> kClass) {
        if(vList == null) {
            return null;
        }
        return vList.stream().map(v -> to(v, kClass)).collect(Collectors.toSet());
    }
}
