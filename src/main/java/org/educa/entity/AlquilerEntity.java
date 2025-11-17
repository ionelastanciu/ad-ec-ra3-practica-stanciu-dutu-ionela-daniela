package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "alquiler")
public class AlquilerEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_ini")
    private LocalDate fechaIni;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    private BigDecimal precio;
    private ClienteEntity cliente;
    private VehiculoEntity vehiculo;
    private SeguroEntity seguro;

}