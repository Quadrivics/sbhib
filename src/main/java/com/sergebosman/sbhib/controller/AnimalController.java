package com.sergebosman.sbhib.controller;

import com.sergebosman.sbhib.entity.Animal;
import com.sergebosman.sbhib.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/animaldata")
public class AnimalController {

    @Autowired
    private IAnimalService animalService;

    @PostMapping("/animal")
    public ResponseEntity<Void> addAnimal(@RequestBody Animal animal, UriComponentsBuilder builder) {

        boolean flag = animalService.addAnimal(animal);
        if(!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("animal/{id}").buildAndExpand(animal.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") Integer id) {
        Animal nml = animalService.getAnimalById(id);
        return new ResponseEntity<Animal>(nml, HttpStatus.OK);
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> list = animalService.getAllAnimals();
        return new ResponseEntity<List<Animal>>(list, HttpStatus.OK);
    }

    @PutMapping("/animal")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal) {
        animalService.updateAnimal(animal);
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/animal/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") Integer id) {
        animalService.deleteAnimal(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
