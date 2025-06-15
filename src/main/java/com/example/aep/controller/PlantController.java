package com.example.aep.controller;

import com.example.aep.model.Plant;
import com.example.aep.service.PlantService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
@CrossOrigin
public class PlantController {
    @Autowired
    private PlantService plantService;

    @PostMapping
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
        try{
            return new ResponseEntity<>(plantService.createPlant(plant), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Plant>> getPlants() {
        return new ResponseEntity<>(plantService.getAllPlants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable int id) {
        try{
            return new ResponseEntity<>(plantService.getPlant(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable int id, @RequestBody Plant plant) {
        try {
            return new ResponseEntity<>(plantService.updatePlant(plant, id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Plant> deletePlant(@PathVariable int id) {
        try{
            return new ResponseEntity<>(plantService.deletePlant(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
