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

    public boolean rent(User user, Book book) {
        if (bookRepository.findOne(book.getId()).isRented()) {
            return false;
        }
        book.setRented(true);
        bookRepository.save(book);
        Rent rent = new Rent(user,book,new Date());
        rentRepository.save(rent);
        return true;
    }

    public boolean giveBeck(User user, Book book){
        if(bookRepository.findOne(book.getId()).isRented() == false){
            return false;
        }

        book.setRented(false);
        bookRepository.save(book);
        Rent tempRent = rentRepository.findByUserAndBookRent(user, book);
        tempRent.setEndDate(new Date());
        rentRepository.save(tempRent);

        return true;
    }

}
