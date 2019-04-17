package com.sergebosman.sbhib.entity;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "gender")
    private String gender;
//
//    @Column(name = "level")
//    private String level;
//
//    @Column(name = "hp")
//    private String hp;
//
//    @Column(name = "condition")
//    private String condition;

    public Animal() {

    }

    public Animal(int id, String name, String species, String gender) {
//        , String level, String hp, String condition
        this.id = id;
        this.name = name;
        this.species = species;
        this.gender = gender;
//        this.level = level;
//        this.hp = hp;
//        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species=" + species +
                ", gender='" + gender + '\'' +
//                ", level='" + level + '\'' +
//                ", hp='" + hp + '\'' +
//                ", condition='" + condition + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String  level) {
//        this.level = level;
//    }
//
//    public String  getHp() {
//        return hp;
//    }
//
//    public void setHp(String  hp) {
//        this.hp = hp;
//    }
//
//    public String getCondition() {
//        return condition;
//    }
//
//    public void setCondition(String condition) {
//        this.condition = condition;
//    }
}
