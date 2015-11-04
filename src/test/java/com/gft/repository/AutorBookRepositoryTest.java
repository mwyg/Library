package com.gft.repository;

import com.gft.config.Application;
import com.gft.model.Autor;
import com.gft.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by mnwi on 04/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class AutorBookRepositoryTest {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    public void saveAutor() {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("title1"));
        books.add(new Book("title2"));

        Autor a = new Autor();
        a.setName("name1");
        a.setSurname("surename1");
        a.setBooks(books);

        autorRepository.save(a);

        Autor foundAutor = autorRepository.findByName("name1");
        assertEquals(2, foundAutor.getBooks().size());
        assertNotNull(bookRepository.findByTitle("title1"));
    }
}
