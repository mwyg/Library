package com.gft.rest;

import org.springframework.web.bind.annotation.*;

/**
 * Created by mnwi on 04/11/2015.
 */
@RestController
public class SaveBookRest {


    @RequestMapping(value = "/addBook/{title}", method = RequestMethod.GET)
    public String addBook(@PathVariable("title") String title){

        return title;
    }


}
