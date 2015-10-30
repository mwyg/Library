package com.gft.service.rent;

import com.gft.model.Book;
import com.gft.model.Rent;
import com.gft.model.User;
import com.gft.repository.BookRepository;
import com.gft.repository.RentRepository;
import com.gft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by mnwi on 30/10/2015.
 */

@Service
public class RentBookImpl  implements RentBook{
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RentRepository rentRepository;

    public boolean rentBook(User user, Book book) {
        if (bookRepository.findOne(book.getId()).isRented()) {
            return false;
        }
        bookRepository.findOne(book.getId()).setRented(true);
        Rent rent = new Rent(user,book,new Date());
        userRepository.findOne(user.getId()).getRented().add(rent);
        rentRepository.save(rent);
        return true;
    }
//
//    public boolean giveBeckBook(User user, Book book){
//        if(bookRepository.findOne(book.getId()).isRented() == false){
//            return false;
//        }
//
//        bookRepository.findOne(book.getId()).setRented(false);
//        rentRepository.findOne()
//
//
//    }

}
