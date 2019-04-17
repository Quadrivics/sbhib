package com.sergebosman.sbhib.DAO;

import com.sergebosman.sbhib.entity.Animal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AnimalDAO implements IAnimalDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAnimal(Animal animal) {
        entityManager.persist(animal);
    }

    @Override
    public boolean animalExists(String name, String species) {
        String jpql = "FROM Animal WHERE name = ?0 and species = ?1";
        int count = entityManager.createQuery(jpql)
                .setParameter(0, name)
                .setParameter(1, species)
                .getResultList()
                .size();
        return count > 0;
    }

    @Override
    public List<Animal> getAllAnimals() {
        //note Animal is the class name; not the table name; class name is case sensitive; use class field names - column names
        String query = "select a from Animal a order by a.name";
        return (List<Animal>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public Animal getAnimalById(int animalId) {
        return entityManager.find(Animal.class, animalId);
    }

    @Override
    public void updateAnimal(Animal animal) {
        Animal nml = getAnimalById(animal.getId());
        nml.setName(animal.getName());
        nml.setGender(animal.getGender());
        nml.setSpecies(animal.getSpecies());
//        nml.setLevel(animal.getLevel());
//        nml.setHp(animal.getHp());
//        nml.setCondition(animal.getCondition());
        entityManager.flush();
    }

    @Override
    public void deleteAnimal(int animalId) {
        entityManager.remove(getAnimalById(animalId));
    }
}
