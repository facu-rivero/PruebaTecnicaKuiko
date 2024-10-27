package com.pruebatecnica.kuikoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMUNIDADES")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CODIGO_CA" ,nullable = false, unique = true)
    private String communityCode;
    @Column(name = "NOMBRE_CA" ,nullable = false)
    private String communityName;

    @OneToMany (mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Province> provinces;
}
