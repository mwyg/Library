package com.gft.repository;

import com.gft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mnwi on 29/10/2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
