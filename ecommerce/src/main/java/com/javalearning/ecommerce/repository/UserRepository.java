package com.javalearning.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javalearning.ecommerce.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
