package com.gft.repository;

import com.gft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by mnwi on 29/10/2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {


}
