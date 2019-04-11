package com.sergebosman.sbhib.service;

import com.sergebosman.sbhib.entity.Animal;

import java.util.List;

public interface IAnimalService {
    boolean addAnimal(Animal animal);
    Animal getAnimalById(int animalId);
    List<Animal> getAllAnimals();
    void updateAnimal(Animal animal);
    void deleteAnimal(int animalId);
}
