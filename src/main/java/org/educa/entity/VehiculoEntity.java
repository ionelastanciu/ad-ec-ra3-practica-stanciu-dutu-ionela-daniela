package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comb")
    private CombustibleEntity combustible;

    @OneToMany(mappedBy = "vehiculo")
    private List<AlquilerEntity> alquileres;

    @ManyToMany()
    @JoinTable(
            name = "vehiculo_equipamiento",
            joinColumns = @JoinColumn(name = "id_vehiculo"),
            inverseJoinColumns = @JoinColumn(name = "id_equip")
    )
    @ToString.Exclude
    private List<EquipamientoEntity> equipamientos;
}