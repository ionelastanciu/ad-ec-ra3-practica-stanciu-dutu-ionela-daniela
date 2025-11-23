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
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    private String nombre;
    @Column(name = "p_apellido")
    private String primerApellido;
    @Column(name = "s_apellido")
    private String segundoApellido;
    private String email;
    private String dni;
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<AlquilerEntity> alquileres;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<DireccionEntity> direcciones;

}