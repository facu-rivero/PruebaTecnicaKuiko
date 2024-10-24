package com.pruebatecnica.kuikoservice.repository;

import com.pruebatecnica.kuikoservice.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
