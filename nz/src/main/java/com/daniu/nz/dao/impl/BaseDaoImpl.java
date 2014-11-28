/*
 * Copyright (c) 2012, 2013, Chuanhe Network Technology Company limited.
 * All rights reserved.
 */
package com.daniu.nz.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.criterion.Order;
import org.springframework.util.CollectionUtils;

import com.daniu.nz.dao.BaseDao;

/**
 * 基础Dao操作抽象类.
 * @author Daniel Liu
 * @createTime 2014-2-10
 * @version V1.0
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @PersistenceContext
    protected EntityManager em;

    private ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();

    /** 实体类. */
    @SuppressWarnings("unchecked")
    private Class<T> entityClass = (Class<T>) (parameterizedType.getActualTypeArguments()[0]);

    /** 实体名. */
    private String entityName = getEntityName(entityClass);

    @Override
    public void save(T t) {
        em.persist(t);
    }

    @Override
    public void delete(T t) {
        em.remove(t);
    }

    @Override
    public void deleteById(long id) {
        StringBuffer sb = new StringBuffer("delete from ");
        sb.append(entityName).append(" where id=").append(id);
        em.createQuery(sb.toString()).executeUpdate();
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        StringBuffer sb = new StringBuffer("delete from ");
        sb.append(entityName).append(" where id in :ids");
        em.createQuery(sb.toString()).setParameter("ids", ids).executeUpdate();
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public void update(long id, Map<String, Object> params) {
        StringBuffer sb = new StringBuffer("update ");
        sb.append(entityName);
        if (!CollectionUtils.isEmpty(params)) {
            sb.append(" set");
            int i = 0;
            for (Entry<String, Object> e : params.entrySet()) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(e.getKey()).append("=?");
                i++;
            }
        }
        sb.append(" where id =:id");
        em.createQuery(sb.toString()).setParameter("id", id).executeUpdate();
    }

    @Override
    public void update(List<Long> ids, String field, String value) {
        StringBuffer sb = new StringBuffer("update ");
        sb.append(entityName).append(" set ").append(field).append(" =:value, updateTime =:ut where id in :ids");
        em.createQuery(sb.toString()).setParameter("ids", ids).setParameter("value", value)
          .setParameter("ut", new Date()).executeUpdate();
    }

    @Override
    public T findById(long id) {
        return em.find(entityClass, id);
    }

    @Override
    public T find(Map<String, Object> params) {
        List<T> list = list(params, null, 0, 1);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public int count(Map<String, Object> params) {
        StringBuffer jpql = new StringBuffer("select count(id) from ").append(entityName).append(" where 1=1");
        List<Entry<String, Object>> list = new ArrayList<Map.Entry<String, Object>>();
        if (!CollectionUtils.isEmpty(params)) {
            list.addAll(params.entrySet());
            for (int i = 0; i < list.size(); i++) {
                String key[] = list.get(i).getKey().split("_");
                if (key.length < 2) {
                    jpql.append(" and ").append(key[0]).append("=").append(":a").append(i);
                } else {
                    String operator = key[1];
                    if ("null".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" is null ");
                    } else if ("eq".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" =").append(" :a").append(i);
                    } else if ("ne".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" !=").append(" :a").append(i);
                    } else if ("lt".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" <").append(" :a").append(i);
                    } else if ("le".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" <=").append(" :a").append(i);
                    } else if ("ge".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" >=").append(" :a").append(i);
                    } else if ("gt".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" >").append(" :a").append(i);
                    } else if ("in".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" in").append(" :a").append(i);
                    } else if ("like".equalsIgnoreCase(operator)) {
                        jpql.append(" and ").append(key[0]).append(" like").append(" :a").append(i);
                    }
                }
            }
        }
        TypedQuery<Long> query = em.createQuery(jpql.toString(), Long.class);
        if (!CollectionUtils.isEmpty(params)) {
            for (int i = 0; i < list.size(); i++) {
                query.setParameter("a" + i, list.get(i).getValue());
            }
        }
        return query.getSingleResult().intValue();
    }

    @Override
    public List<T> list(Map<String, Object> params, Order order, int index, int size) {
        StringBuffer jpql = new StringBuffer("from ").append(entityName).append(" where 1=1");
        List<Entry<String, Object>> list = new ArrayList<Map.Entry<String, Object>>();
        list.addAll(params.entrySet());
        for (int i = 0; i < list.size(); i++) {
            String key[] = list.get(i).getKey().split("_");
            if (key.length < 2) {
                jpql.append(" and ").append(key[0]).append("=").append(":a").append(i);
            } else {
                String operator = key[1];
                if ("null".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" is null ");
                } else if ("eq".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" =").append(" :a").append(i);
                } else if ("ne".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" !=").append(" :a").append(i);
                } else if ("lt".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" <").append(" :a").append(i);
                } else if ("le".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" <=").append(" :a").append(i);
                } else if ("ge".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" >=").append(" :a").append(i);
                } else if ("gt".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" >").append(" :a").append(i);
                } else if ("in".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" in").append(" :a").append(i);
                } else if ("like".equalsIgnoreCase(operator)) {
                    jpql.append(" and ").append(key[0]).append(" like").append(" :a").append(i);
                }
            }
        }
        if (order != null) {
            jpql.append(" order by ").append(order.toString());
        }
        TypedQuery<T> query = em.createQuery(jpql.toString(), entityClass);
        for (int i = 0; i < list.size(); i++) {
            query.setParameter("a" + i, list.get(i).getValue());
        }
        query.setFirstResult(index);
        if (size > 0) {
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    /**
     * 获取实体的名称.
     * @param entityClass 实体类
     * @return {@linkplain String}
     */
    private String getEntityName(Class<T> entityClass) {
        String entityname = entityClass.getSimpleName();
        Entity entity = entityClass.getAnnotation(Entity.class);
        if (entity.name() != null && !entity.name().equals("")) {
            entityname = entity.name();
        }
        return entityname;
    }
}
