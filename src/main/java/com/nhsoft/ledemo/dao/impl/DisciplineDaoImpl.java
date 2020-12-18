package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Discipline;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 10:31
 */
@Repository
public class DisciplineDaoImpl extends BaseDao implements DisciplineDao {

    @Override
    public Collection<Discipline> batchSave(Collection<Discipline> disciplineCollection) {
        disciplineCollection.forEach(discipline -> entityManager.persist(discipline));
        return disciplineCollection;
    }

    @Override
    public Collection<Discipline> batchUpdate(Collection<Discipline> disciplineCollection) {
        disciplineCollection.forEach(discipline -> entityManager.merge(discipline));
        return disciplineCollection;
    }

    @Override
    public Collection<Long> batchDelete(Collection<Long> disIdCollection) {

        String jpql = "delete from Discipline  where disId = ?1";
        Query query = entityManager.createQuery(jpql);
        disIdCollection.forEach(id -> query.setParameter(1, id).executeUpdate());
        return disIdCollection;
    }

    @Override
    public List<Discipline> listAll(PagingDTO pagingDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Discipline> query = criteriaBuilder.createQuery(Discipline.class);

        query.from(Discipline.class);
        return entityManager.createQuery(query).setFirstResult(pagingDTO.getPage()).setMaxResults(pagingDTO.getSize()).getResultList();
    }

    @Override
    public Discipline readById(Long disId) {
        return entityManager.find(Discipline.class, disId);
    }
}
