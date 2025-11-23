package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.ClienteEntity;
import org.hibernate.Session;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public ClienteEntity findByDNI(String dni) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {

            String hql = "FROM ClienteEntity c WHERE c.dni = :dni";
            ClienteEntity cliente = session.createQuery(hql, ClienteEntity.class).setParameter("dni", dni).setReadOnly(true).uniqueResult();

            if (cliente != null) {

                cliente.getDirecciones().size();
                cliente.getAlquileres().size();

                cliente.getAlquileres().forEach(a -> {
                    var v = a.getVehiculo();
                    if (v != null) {
                        v.getId();

                        if (v.getCategoria() != null) v.getCategoria().getId();

                        if (v.getCombustible() != null) v.getCombustible().getId();

                        if (v.getSucursal() != null) v.getSucursal().getId();

                        if (v.getEquipamientos() != null) v.getEquipamientos().size();
                    }
                    var s = a.getSeguro();
                    if (s != null) s.getId();
                });
            }
            return cliente;
        }
    }

    @Override
    public void saveCliente(ClienteEntity cliente) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(cliente);
            session.getTransaction().commit();
        }
    }
}
