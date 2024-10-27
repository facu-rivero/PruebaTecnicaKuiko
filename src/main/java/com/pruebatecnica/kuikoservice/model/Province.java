package com.pruebatecnica.kuikoservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROVINCIAS")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CODIGO_PROVINCIA" ,nullable = false)
    private String provinceCode;
    @Column(name = "NOMBRE_PROVINCIA" ,nullable = false)
    private String provinceName;

    @ManyToOne
    @JoinColumn(name = "CODIGO_CA",referencedColumnName = "CODIGO_CA")
    private Community community;
}
