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
    private Long bookId;
    private String title;
    private boolean rented;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rentHistory;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "book_autor", joinColumns = {@JoinColumn(name = "bookId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "autorId", nullable = false, updatable = false)})
    private List<Autor> autors;


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
        return bookId;
    }

    public void setId(Long id) {
        this.bookId = id;
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

    public List<Autor> getAutors() {
        return autors;
    }

    public void setAutors(List<Autor> autors) {
        this.autors = autors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", title='" + title + '\'' +
                '}';
    }
}
