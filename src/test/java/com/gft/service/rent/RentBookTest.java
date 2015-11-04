package com.gft.service.rent;

import com.gft.config.Application;
import com.gft.model.Book;
import com.gft.model.Rent;
import com.gft.model.User;
import com.gft.repository.BookRepository;
import com.gft.repository.RentRepository;
import com.gft.repository.UserRepository;
import org.junit.After;
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
    RentBook rentBook;

    @Test
    public void rentAndGiveAndBackTest() {
        User u1 = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            u1 = new User("Roman", "Romantyczny", simpleDateFormat.parse("17/12/1992"));
            userRepository.save(u1);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Book b1 = new Book("title1");
        Book b2 = new Book("title2");
        userRepository.save(u1);
        bookRepository.save(b1);
        bookRepository.save(b2);


        rentBook.rent(u1, b1);
        rentBook.rent(u1, b2);
        Rent rented1 = rentRepository.findByUserAndBookRent(u1, b1);
        Rent rented2 = rentRepository.findByUserAndBookRent(u1, b2);

        assertEquals(null, rented1.getEndDate());
        assertEquals(null, rented2.getEndDate());
        assertEquals(true, bookRepository.findOne(b1).isRented());
        assertEquals(true, bookRepository.findOne(b2).isRented());

        rentBook.giveBeck(u1, b1);
        assertEquals(false, bookRepository.findOne(b1).isRented());
        assertEquals(true, bookRepository.findOne(b2).isRented());

        assertEquals(null, rentRepository.findByUserAndBookRent(u1, b2).getEndDate());

    }

    @Test
    public void rentTheBookManyTimes() {
        User u2 = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            u2 = new User("Roman2", "Romantyczn2", simpleDateFormat.parse("17/12/1992"));
            userRepository.save(u2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book b3 = new Book("title3");
        Book b4 = new Book("title4");
        userRepository.save(u2);
        bookRepository.save(b3);
        bookRepository.save(b4);


        rentBook.rent(u2, b3);
        assertEquals(true, bookRepository.findOne(b3.getId()).isRented());
        rentBook.giveBeck(u2, b3);
        assertEquals(false, bookRepository.findOne(b3.getId()).isRented());
        rentBook.rent(u2, b3);
        assertEquals(true, bookRepository.findOne(b3.getId()).isRented());
        rentBook.giveBeck(u2, b3);

        List<Rent> all = rentRepository.findByUserAndBookGivedBack(u2, b3);
    }

}