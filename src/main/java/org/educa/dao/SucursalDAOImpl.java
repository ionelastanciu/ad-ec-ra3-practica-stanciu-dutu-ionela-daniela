package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.SucursalEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SucursalDAOImpl implements SucursalDAO {
    @Override
    public List<SucursalEntity> findAll() {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM SucursalEntity";
            Query<SucursalEntity> query = session.createQuery(hql, SucursalEntity.class);
            return query.list();
        }
    }
}
