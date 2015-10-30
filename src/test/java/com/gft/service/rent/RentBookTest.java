package com.gft.service.rent;

import com.gft.config.Application;
import com.gft.model.Book;
import com.gft.model.Rent;
import com.gft.model.User;
import com.gft.repository.BookRepository;
import com.gft.repository.RentRepository;
import com.gft.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by iozi on 06/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class RentBookTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    RentRepository rentRepository;
    @Autowired
    RentBookImpl rentBookImpl;

    User u1;
    Book b1;
    @Before
    public void init(){

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            u1 = new User("Roman", "Romantyczny", simpleDateFormat.parse("17/12/1992"));
            userRepository.save(u1);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        b1 = new Book("title1");

        userRepository.save(u1);
        bookRepository.save(b1);

    }


    @Test
    public void rentBookTest() {
        rentBookImpl.rentBook(u1, b1);
        List<Rent> all =  rentRepository.findAll();

            System.out.println(all.get(0));
    }
}