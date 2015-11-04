package com.gft.repository;

import com.gft.config.Application;
import com.gft.model.Book;
import com.gft.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * Created by mnwi on 03/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class BookRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;


    User u1;
    Book b1;

    @Before
    public void init() {


        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            u1 = new User("Roman", "Romantyczny", simpleDateFormat.parse("17/12/1992"));
            userRepository.save(u1);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        b1 = new Book("title1");
    }


    @Test
    public void addBookTest() {
        bookRepository.save(b1);
        Book foundBook = bookRepository.findOne(b1.getId());
        assertEquals("title1", foundBook.getTitle());
        assertEquals(false, foundBook.isRented());
        System.out.println(foundBook);
    }
}
