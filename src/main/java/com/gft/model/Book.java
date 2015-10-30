package com.gft.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mnwi on 29/10/2015.
 */

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private boolean rented;
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "book", cascade = CascadeType.ALL)
    private List<Rent> rentHistory;


    public Book(String title) {
        this.title = title;
        this.rented = false;
    }

    public Book() {
        this.rented = false;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }


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

    public List<Rent> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(List<Rent> rentHistory) {
        this.rentHistory = rentHistory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rented=" + rented +
                ", rentHistory=" + rentHistory +
                '}';
    }
}
