package org.educa.dao;

import org.educa.entity.SeguroEntity;

import java.util.List;

public interface SeguroDAO {
    /*
     * Método para obtener todos los seguros.
     */
    List<SeguroEntity> findAll();
}
