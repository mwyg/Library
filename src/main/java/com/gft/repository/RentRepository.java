package com.gft.repository;

import com.gft.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mnwi on 30/10/2015.
 */
public interface RentRepository extends JpaRepository<Rent, Long > {
}
