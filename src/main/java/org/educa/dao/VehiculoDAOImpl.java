package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.SucursalEntity;
import org.educa.entity.VehiculoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO {
    @Override
    public List<VehiculoEntity> findBySucursal(SucursalEntity sucursal) {
        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM VehiculoEntity v WHERE v.id_sucursal = :id";
            Query<VehiculoEntity> query = session.createQuery(hql, VehiculoEntity.class)
                    .setParameter("id", sucursal.getId()).setReadOnly(true);
            return query.list();
        }
    }
}
