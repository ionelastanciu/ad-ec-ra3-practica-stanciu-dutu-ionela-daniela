package org.educa.dao;

import org.educa.entity.SucursalEntity;
import org.educa.entity.VehiculoEntity;

import java.util.List;

public interface VehiculoDAO {
    /**
     * Método para obtener todos los vehículos.
     */
    List<VehiculoEntity> findBySucursal(SucursalEntity sucursal);
}
