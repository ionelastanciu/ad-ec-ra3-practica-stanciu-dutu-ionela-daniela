package org.educa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "combustible")
public class CombustibleEntity {

    private Integer id;
    private String nombre;
    private String descripcion;
    private List<VehiculoEntity> vehiculos;

}