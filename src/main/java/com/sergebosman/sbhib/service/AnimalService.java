package com.sergebosman.sbhib.service;

import com.sergebosman.sbhib.DAO.IAnimalDAO;
import com.sergebosman.sbhib.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService implements IAnimalService{

    @Autowired
    private IAnimalDAO animalDAO;

    @Override
    public synchronized boolean addAnimal(Animal animal) {
        if(animalDAO.animalExists(animal.getName(), animal.getSpecies())) {
            return false;
        } else{
            animalDAO.addAnimal(animal);
            return true;
        }
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalDAO.getAllAnimals();
    }

    @Override
    public Animal getAnimalById(int animalId) {
        return animalDAO.getAnimalById(animalId);
    }

    @Override
    public void updateAnimal(Animal animal) {
        animalDAO.updateAnimal(animal);
    }

    @Override
    public void deleteAnimal(int animalId) {
        animalDAO.deleteAnimal(animalId);
    }
}
