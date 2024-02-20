package com.examples.rest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String country;
    private Integer yearofconstruction;
    private String director;

    public Movie() {
    }

    public Movie(Long id, String name, String country, Integer yearofconstruction, String director) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.yearofconstruction = yearofconstruction;
        this.director = director;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYearofconstruction() {
        return yearofconstruction;
    }

    public void setYearofconstruction(Integer yearofconstruction) {
        this.yearofconstruction = yearofconstruction;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
