package com.gft.repository;

import com.gft.model.Book;
import com.gft.model.Rent;
import com.gft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mnwi on 30/10/2015.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b = (:book)")
    public Book findOne(@Param("book")Book book);

//    @Query("SELECT r FROM Rent r WHERE r.book = (:book) AND r.user = (:user) AND r.endDate IS NOT NULL")
//    public List<Rent> findByUserAndBookGivedBack(@Param("user") User user, @Param("book") Book book);
}
