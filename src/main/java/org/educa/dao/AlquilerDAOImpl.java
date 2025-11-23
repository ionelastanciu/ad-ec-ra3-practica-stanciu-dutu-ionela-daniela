package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.AlquilerEntity;
import org.hibernate.Session;

public class AlquilerDAOImpl implements AlquilerDAO {
    @Override
    public void save(AlquilerEntity alquiler) {
        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(alquiler);
            session.getTransaction().commit();
        }
    }
}
