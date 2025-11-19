package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehiculo")
public class VehiculoEntity implements Serializable {
    @Serial
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer id;
    private String matricula;
    private String bastidor;
    private String marca;
    private String modelo;
    private String color;
    private Integer anio;
    private CategoriaEntity categoria;
    private SucursalEntity sucursal;
    private CombustibleEntity combustible;
    private List<AlquilerEntity> alquileres;
    private List<EquipamientoEntity> equipamientos;
}