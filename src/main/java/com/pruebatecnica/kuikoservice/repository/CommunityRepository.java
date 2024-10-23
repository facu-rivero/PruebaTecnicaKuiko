package com.pruebatecnica.kuikoservice.repository;

import com.pruebatecnica.kuikoservice.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
}
