package org.educa.dao;

import org.educa.entity.SucursalEntity;

import java.util.List;

public interface SucursalDAO {
    /*
     * Método para obtener todas las sucursales.
     */
    List<SucursalEntity> findAll();
}
