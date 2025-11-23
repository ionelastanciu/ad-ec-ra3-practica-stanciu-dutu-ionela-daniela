package org.educa.dao;

import org.educa.entity.AlquilerEntity;
import org.educa.entity.ClienteEntity;

import java.util.List;

public interface AlquilerDAO {

    /**
     * Método para guardar un alquiler.
     */
    void save(AlquilerEntity alquiler);

    /**
     * Método para contar los alquileres de un cliente.
     */
    int countByCliente(ClienteEntity cliente);

    /**
     * Método para obtener los alquileres de un cliente.
     */
    List<AlquilerEntity> findByCliente(ClienteEntity cliente);
}
