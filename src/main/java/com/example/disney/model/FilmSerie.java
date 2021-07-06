package com.example.disney.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FilmSerie{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private Date date;

    @Column
    private int score;

    @Column
    private String image;



    /*
    * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "FK_matter"
			,joinColumns = {@JoinColumn(name = "user_id")}
	        ,inverseJoinColumns = {@JoinColumn(name = "matter_id")})
	private Set<Matter> matter = new HashSet<>();
    * */

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "filmS_personage"
             ,joinColumns = {@JoinColumn(name = "filmS_id")}
             ,inverseJoinColumns = {@JoinColumn(name = "personage_id")})
    private Set<Personage> personage = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Personage> getPersonage() {
        return personage;
    }

    public void setPersonage(Set<Personage> personage) {
        this.personage = personage;
    }


}
