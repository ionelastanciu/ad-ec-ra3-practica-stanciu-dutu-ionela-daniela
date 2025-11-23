package org.educa.service;

import org.educa.dao.SeguroDAO;
import org.educa.dao.SeguroDAOImpl;
import org.educa.entity.SeguroEntity;

import java.math.BigDecimal;
import java.util.List;

public class SeguroService {
    private final SeguroDAO seguroDAO = new SeguroDAOImpl();

    public List<SeguroEntity> findAll() {

        return seguroDAO.findAll();
    }

    public BigDecimal getPrecioPorDia(SeguroEntity seguro) {
        String nombre = seguro.getNombre().toLowerCase();
        if (nombre.contains("terceros")) return BigDecimal.valueOf(5);
        if (nombre.contains("300")) return BigDecimal.valueOf(20);
        if (nombre.contains("150")) return BigDecimal.valueOf(35);
        if (nombre.contains("todo riesgo")) return BigDecimal.valueOf(50);
        return BigDecimal.ZERO;
    }
}
