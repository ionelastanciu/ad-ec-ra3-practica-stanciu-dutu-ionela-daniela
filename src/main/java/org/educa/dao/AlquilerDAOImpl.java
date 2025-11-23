package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.AlquilerEntity;
import org.educa.entity.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AlquilerDAOImpl implements AlquilerDAO {

    @Override
    public void save(AlquilerEntity alquiler) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(alquiler);
            session.getTransaction().commit();
        }
    }

    @Override
    public int countByCliente(ClienteEntity cliente) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(a) FROM AlquilerEntity a WHERE a.cliente.id = :idCliente";
            Long count = session.createQuery(hql, Long.class).setParameter("idCliente", cliente.getId()).setReadOnly(true).uniqueResult();

            return count != null ? count.intValue() : 0;
        }
    }

    @Override
    public List<AlquilerEntity> findByCliente(ClienteEntity cliente) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            String hql = "FROM AlquilerEntity a WHERE a.cliente.id = :idCliente";
            Query<AlquilerEntity> query = session.createQuery(hql, AlquilerEntity.class).setParameter("idCliente", cliente.getId()).setReadOnly(true);

            return query.list();
        }
    }
}
