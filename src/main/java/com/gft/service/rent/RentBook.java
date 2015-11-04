package com.gft.service.rent;

import com.gft.model.Book;
import com.gft.model.User;

/**
 * Created by mnwi on 30/10/2015.
 */
public interface RentBook {
    public boolean rent(User user, Book book);
    public boolean giveBeck(User user, Book book);
}
