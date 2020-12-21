package com.nhsoft.ledemo.dao.impl;

import com.nhsoft.ledemo.dao.BaseDao;
import com.nhsoft.ledemo.dao.DisciplineDao;
import com.nhsoft.ledemo.dto.PagingDTO;
import com.nhsoft.ledemo.model.Discipline;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

/**
 * @author hcsheng1998
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

        String jpql = "delete from Discipline  where disId = :disId";
        Query query = entityManager.createQuery(jpql);
        disIdCollection.forEach(id -> {
            query.setParameter("disId", id);
            query.executeUpdate();
        });
        return disIdCollection;
    }

    @Override
    public List<Discipline> listAll(PagingDTO pagingDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Discipline> criteriaQuery = criteriaBuilder.createQuery(Discipline.class);
        criteriaQuery.from(Discipline.class);

        TypedQuery<Discipline> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(pagingDTO.getOffset());
        typedQuery.setMaxResults(pagingDTO.getRows());
        return typedQuery.getResultList();
    }

    @Override
    public Discipline read(Long disId) {
        return entityManager.find(Discipline.class, disId);
    }
}
