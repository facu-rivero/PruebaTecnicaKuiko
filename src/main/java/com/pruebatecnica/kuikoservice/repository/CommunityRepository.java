package com.pruebatecnica.kuikoservice.repository;

import com.pruebatecnica.kuikoservice.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    Optional<Community> findByCommunityCode(String communityCode);
}
