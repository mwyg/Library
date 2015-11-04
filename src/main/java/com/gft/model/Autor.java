package com.gft.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mnwi on 29/10/2015.
 */

public class Autor {
    @Id
    @GeneratedValue
    @Column(name = "AUTOR_ID")
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autor")
//    private List<Book> books;

}
