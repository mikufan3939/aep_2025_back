package com.example.aep.repository;

import com.example.aep.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
}
