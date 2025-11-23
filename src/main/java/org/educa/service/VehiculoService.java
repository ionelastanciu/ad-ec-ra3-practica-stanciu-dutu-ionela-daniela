package org.educa.service;

import org.educa.dao.VehiculoDAO;
import org.educa.dao.VehiculoDAOImpl;
import org.educa.entity.SucursalEntity;
import org.educa.entity.VehiculoEntity;

import java.math.BigDecimal;
import java.util.List;

public class VehiculoService {

    private final VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();

    /**
     * Obtiene una lista de vehículos pertenecientes a una sucursal específica.
     *
     * @param sucursal la Sucursal
     * @return lista de Vehículos
     */
    public List<VehiculoEntity> findBySucursal(SucursalEntity sucursal) {
        return vehiculoDAO.findBySucursal(sucursal);
    }

    /**
     * Obtiene el precio por día del vehículo dependiendo de la categoria del mismo
     *
     * @param vehiculo el Vehículo
     * @return el precio por día
     */
    public BigDecimal getPrecioPorDia(VehiculoEntity vehiculo) {
        String categoria = vehiculo.getCategoria().getNombre().toUpperCase();
        return switch (categoria){
            case "M" -> BigDecimal.valueOf(10);
            case "E" -> BigDecimal.valueOf(20);
            case "C" -> BigDecimal.valueOf(70);
            case "S" -> BigDecimal.valueOf(120);
            case "P" -> BigDecimal.valueOf(200);
            default -> BigDecimal.ZERO;
        };
    }

}
