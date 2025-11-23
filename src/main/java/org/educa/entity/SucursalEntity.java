package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sucursal")
public class SucursalEntity implements Serializable {
    @Serial
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer id;
    private String calle;
    private String ciudad;
    private String pais;
    private String cp;

    @OneToMany(mappedBy = "sucursal")
    private List<VehiculoEntity> vehiculos;

}