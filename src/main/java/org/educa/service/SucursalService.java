package org.educa.service;

import org.educa.dao.SucursalDAO;
import org.educa.dao.SucursalDAOImpl;
import org.educa.entity.SucursalEntity;

import java.util.List;

public class SucursalService {

    private final SucursalDAO sucursalDAO = new SucursalDAOImpl();

    public List<SucursalEntity> findAll() {
        return sucursalDAO.findAll();
    }
}
