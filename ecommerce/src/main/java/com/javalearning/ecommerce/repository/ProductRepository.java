package com.javalearning.ecommerce.repository;

import com.javalearning.ecommerce.model.Product;
import com.javalearning.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
