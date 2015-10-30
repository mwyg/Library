package com.gft.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile ListAttribute<User, Rent> rented;
	public static volatile SingularAttribute<User, String> surname;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, Date> birth;
	public static volatile SingularAttribute<User, Long> id;

}

