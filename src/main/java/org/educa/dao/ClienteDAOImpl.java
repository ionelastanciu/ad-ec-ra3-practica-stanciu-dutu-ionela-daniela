package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public ClienteEntity findByDNI(String dni) {
        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM ClienteEntity c WHERE c.dni = :dni";
            Query<ClienteEntity> query = session.createQuery(hql, ClienteEntity.class)
                    .setParameter("dni", dni).setReadOnly(true);
            return query.uniqueResult();
        }
    }

    @Override
    public void saveCliente(ClienteEntity cliente) {
        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(cliente);
            session.getTransaction().commit();
        }
    }
}
