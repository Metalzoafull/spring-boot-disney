package com.example.disney.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "genders")
    private Set<FilmSerie> filmSeries = new HashSet<>();


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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<FilmSerie> getFilmSeries() {
        return filmSeries;
    }

    public void setFilmSeries(Set<FilmSerie> filmSeries) {
        this.filmSeries = filmSeries;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
