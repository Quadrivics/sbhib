package com.sergebosman.sbhib.DAO;

import com.sergebosman.sbhib.entity.Animal;

import java.util.List;

public interface IAnimalDAO {
    void addAnimal(Animal animal);
    List<Animal> getAllAnimals();
    boolean animalExists(String name, String species);
    Animal getAnimalById(int animalId);
    void updateAnimal(Animal animal);
    void deleteAnimal(int animalId);
}
