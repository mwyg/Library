package com.gft.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by mnwi on 29/10/2015.
 */

@Entity
public class Rent {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "userId")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "book", referencedColumnName = "bookId")
    private Book book;

    @NotNull
    private Date startDate;
    private Date endDate;

    public Rent(User user, Book book, Date startDate) {
        this.user = user;
        this.book = book;
        this.startDate = startDate;
    }

    public Rent(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", user name=" + user.getName() +
                ", user surname=" + user.getSurname() +
                ", book title=" + book.getTitle() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
