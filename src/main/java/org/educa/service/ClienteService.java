package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.ClienteDAOImpl;
import org.educa.entity.ClienteEntity;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    public ClienteEntity findByDNI(String dni) {

        return clienteDAO.findByDNI(dni);
    }


    public void saveCliente(ClienteEntity cliente) {

        clienteDAO.saveCliente(cliente);
    }
}
