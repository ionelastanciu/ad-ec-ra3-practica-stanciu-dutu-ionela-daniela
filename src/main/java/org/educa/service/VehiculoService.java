package org.educa.service;

import org.educa.entity.SucursalEntity;
import org.educa.entity.VehiculoEntity;

import java.math.BigDecimal;
import java.util.List;

public class VehiculoService {

    public List<VehiculoEntity> findBySucursal(SucursalEntity sucursal) {
        return null;
    }

    /**
     * Obtiene el precio por día del vehículo dependiendo de la categoria del mismo
     *
     * @param vehiculo el Vehículo
     * @return el precio por día
     */
    public BigDecimal getPrecioPorDia(VehiculoEntity vehiculo) {
        return null;
    }

}
