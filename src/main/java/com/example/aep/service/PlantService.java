package com.example.aep.service;

import com.example.aep.model.Plant;
import com.example.aep.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public Plant getPlant(int id) {
        return plantRepository.findById(id).orElseThrow();
    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Plant createPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public Plant updatePlant(Plant plant, int id) {
        Plant updatedPlant = plantRepository.findById(id).orElseThrow();
        updatedPlant.setName(plant.getName());
        updatedPlant.setDescription(plant.getDescription());
        updatedPlant.setPlantType(plant.getPlantType());
        updatedPlant.setAge(plant.getAge());
        updatedPlant.setLastWatered(plant.getLastWatered());
        updatedPlant.setHoursToWater(plant.getHoursToWater());
        return plantRepository.save(updatedPlant);
    }

    public Plant deletePlant(int id) {
        Plant plant = plantRepository.findById(id).orElseThrow();
        plantRepository.deleteById(id);
        return plant;
    }
}
