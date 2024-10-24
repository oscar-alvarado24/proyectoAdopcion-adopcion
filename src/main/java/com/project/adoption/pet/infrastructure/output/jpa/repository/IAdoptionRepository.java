package com.project.adoption.pet.infrastructure.output.jpa.repository;
import com.project.adoption.pet.infrastructure.output.jpa.entity.AdoptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAdoptionRepository extends JpaRepository<AdoptionEntity, Long> {
    List<AdoptionEntity> findByEmail(String email);
}
