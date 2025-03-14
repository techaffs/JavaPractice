package com.javalearning.ecommerce.service;

import com.javalearning.ecommerce.model.Product;
import com.javalearning.ecommerce.model.User;
import com.javalearning.ecommerce.repository.ProductRepository;
import com.javalearning.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> listAllProduct(){
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public Product getProduct(Integer id){
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
