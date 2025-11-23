package org.educa.service;

import org.educa.dao.AlquilerDAO;
import org.educa.dao.AlquilerDAOImpl;
import org.educa.entity.AlquilerEntity;

public class AlquilerService {

    private final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();

    public void save(AlquilerEntity alquiler) {

        alquilerDAO.save(alquiler);
    }

    public void calculatePrecio(AlquilerEntity alquiler, int numAlquileres) {

    }
}
