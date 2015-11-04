package com.gft.repository;

import com.gft.model.Autor;
import com.gft.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mnwi on 04/11/2015.
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.name = (:name)")
    public Autor findByName(@Param("name") String name);

}
