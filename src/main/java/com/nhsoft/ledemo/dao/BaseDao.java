package com.nhsoft.ledemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author heChangSheng
 * @date 2020/12/17 : 9:30
 */
public class BaseDao {

    @PersistenceContext
    public EntityManager entityManager;
}
