package com.pruebatecnica.kuikoservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROVINCIA")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CODIGO_PROVINCIA" ,nullable = false)
    private String provinceCode;
    @Column(name = "NOMBRE_PROVINCIA" ,nullable = false)
    private String provinceName;
    @Column(name = "CODIGO_CA" ,nullable = false)
    private String communityCode;

    @ManyToOne
    @JoinColumn(name = "CODIGO_CA",referencedColumnName = "communityCode")
    private Community community;
}
