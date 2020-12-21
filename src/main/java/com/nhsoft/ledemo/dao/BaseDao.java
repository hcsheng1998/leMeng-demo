package com.nhsoft.ledemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author hcsheng1998
 */
public class BaseDao {

    @PersistenceContext
    public EntityManager entityManager;
}
