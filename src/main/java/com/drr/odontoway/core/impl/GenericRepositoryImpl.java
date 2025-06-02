package com.drr.odontoway.core.impl;

import java.util.List;

import com.drr.odontoway.core.GenericRepository;
import com.drr.odontoway.core.JpaUtil;

import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

public class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {

	@Inject
	private JpaUtil jpaUtil;
	
	private Class<T> entityClass;
	
	public GenericRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
	
	@Override
	public List<T> findAll() {
		CriteriaBuilder cb = this.jpaUtil.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(this.entityClass);
		Root<T> root = criteriaQuery.from(this.entityClass);
		criteriaQuery.select(root);
		TypedQuery<T> query = this.jpaUtil.getEntityManager().createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public T findById(ID id) {
		return this.jpaUtil.getEntityManager().find(this.entityClass, id);
	}
	
	@Override
	@Transactional
	public T create(T t) {
		this.jpaUtil.getEntityManager().persist(t);
		return t;
	}

	@Override
	@Transactional
	public T update(T t) {
		return this.jpaUtil.getEntityManager().merge(t);
	}

	@Override
	@Transactional
	public void delete(ID id) {
		this.jpaUtil.getEntityManager().remove(this.jpaUtil.getEntityManager().find(this.entityClass, id));
	}

}
