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

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * Created by mnwi on 03/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

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
    }

    @Test
    public void addUserTest() {
        userRepository.save(u1);
        User foundUser = userRepository.findOne(u1.getId());
        assertEquals("Roman", foundUser.getName());
        assertEquals("Romantyczny", foundUser.getSurname());
        System.out.println(foundUser);
    }



}
