package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.SeguroEntity;
import org.hibernate.Session;

import java.util.List;

public class SeguroDAOImpl implements SeguroDAO {
    @Override
    public List<SeguroEntity> findAll() {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            return session.createQuery("FROM SeguroEntity", SeguroEntity.class).list();
        }
    }
}
