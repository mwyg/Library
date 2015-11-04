package com.gft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mnwi on 29/10/2015.
 */

@Entity
public class Book {

    @Id
    @GeneratedValue
   // @Column(name = "BOOK_ID")
    private Long id;
    private String title;
    private boolean rented;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rentHistory;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "book_autor", joinColumns = {@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "AUTOR_ID", nullable = false, updatable = false)})
//    private List<Autor> autors;


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
                '}';
    }
}
