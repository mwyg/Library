package com.gft.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rent.class)
public abstract class Rent_ {

	public static volatile SingularAttribute<Rent, Date> endDate;
	public static volatile SingularAttribute<Rent, Book> book;
	public static volatile SingularAttribute<Rent, Long> id;
	public static volatile SingularAttribute<Rent, User> user;
	public static volatile SingularAttribute<Rent, Date> startDate;

}

