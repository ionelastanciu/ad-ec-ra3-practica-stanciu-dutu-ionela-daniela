package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.ClienteDAOImpl;
import org.educa.entity.ClienteEntity;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    /**
     * Método para obtener un cliente por su DNI.
     */
    public ClienteEntity findByDNI(String dni) {
        return clienteDAO.findByDNI(dni);
    }

    /**
     * Método para guardar un cliente.
     */
    public void saveCliente(ClienteEntity cliente) {
        clienteDAO.saveCliente(cliente);
    }
}
