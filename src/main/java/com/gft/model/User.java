package com.gft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by mnwi on 29/10/2015.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Date birth;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rented;

    public User(String name, String surname, Date birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public User() {
    }


    public List<Rent> getRented() {
        return rented;
    }

    public void setRented(List<Rent> rented) {
        this.rented = rented;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
