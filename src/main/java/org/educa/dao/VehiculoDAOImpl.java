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
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = """
                    SELECT DISTINCT v
                    FROM VehiculoEntity v
                    LEFT JOIN FETCH v.categoria
                    LEFT JOIN FETCH v.equipamientos
                    WHERE v.sucursal.id = :id
                    """;
            Query<VehiculoEntity> query = session.createQuery(hql, VehiculoEntity.class)
                    .setParameter("id", sucursal.getId()).setReadOnly(true);
            List<VehiculoEntity> list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }
}
