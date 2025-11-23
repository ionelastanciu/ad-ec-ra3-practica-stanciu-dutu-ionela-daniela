package org.educa.service;

import org.educa.dao.AlquilerDAO;
import org.educa.dao.AlquilerDAOImpl;
import org.educa.entity.AlquilerEntity;
import org.educa.entity.ClienteEntity;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class AlquilerService {

    private final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();

    /**
     * Guarda un objeto AlquilerEntity en la base de datos.
     *
     * @param alquiler El objeto AlquilerEntity a guardar.
     */
    public void save(AlquilerEntity alquiler) {
        alquilerDAO.save(alquiler);
    }

    /**
     * Calcula el precio de un alquiler teniendo en cuenta los días de alquiler,
     * el precio por día del vehículo y del seguro, y aplica un descuento
     * si el cliente ha realizado más de 10 alquileres.
     *
     * @param alquiler              El objeto AlquilerEntity para el cual se calculará el precio.
     * @param numAlquileresIgnorado Número de alquileres a ignorar (no se utiliza en este método).
     */
    public void calculatePrecio(AlquilerEntity alquiler, int numAlquileresIgnorado) {

        ClienteEntity cliente = alquiler.getCliente();
        int numAlquileresReal = alquilerDAO.countByCliente(cliente);

        long dias = ChronoUnit.DAYS.between(
                alquiler.getFechaIni(),
                alquiler.getFechaFin()
        );

        BigDecimal precioDiaVehiculo = new VehiculoService().getPrecioPorDia(alquiler.getVehiculo());

        BigDecimal precioDiaSeguro = new SeguroService().getPrecioPorDia(alquiler.getSeguro());

        BigDecimal precioTotal = (precioDiaVehiculo.add(precioDiaSeguro))
                .multiply(BigDecimal.valueOf(dias));

        if (numAlquileresReal > 10) {
            precioTotal = precioTotal.multiply(BigDecimal.valueOf(0.95));
        }

        alquiler.setPrecio(precioTotal);
    }
}
