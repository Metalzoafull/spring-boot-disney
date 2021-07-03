package com.example.disney.model;


import javax.persistence.*;
import java.lang.Float;

//declaro todas las clases que poseo con el @Entity, para darle a enter al mapeo que esta clase es una entidad de base de datos
@Entity
public class Personage {

    //aclaro al mapeo que "id" sera mi id de primary key de base de datos, tambien dejo en claro que tendra un tipo de generacion automatica
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //al resto de valores de la base de datos les asignos un @Column para que el mapeo entienda que son columna de la base de datos, y asi poder crearlas en la base de datos
    @Column
    private String name;

    @Column
    private Long age;

    @Column
    private Float weight;

    @Column
    private String history;

    @Column
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
