package org.educa.dao;

import org.educa.entity.ClienteEntity;

public interface ClienteDAO {
    /** Busca un cliente por su DNI.
     *
     * @param dni El DNI del cliente a buscar.
     * @return La entidad ClienteEntity correspondiente al DNI proporcionado.
     */
    ClienteEntity findByDNI(String dni);

    /** Guarda un cliente en la base de datos.
     *
     * @param cliente La entidad ClienteEntity a guardar.
     */
    void saveCliente(ClienteEntity cliente);
}
