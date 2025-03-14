package com.javalearning.ecommerce.controller;

import com.javalearning.ecommerce.model.Product;
import com.javalearning.ecommerce.model.User;
import com.javalearning.ecommerce.service.ProductService;
import com.javalearning.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> list(){
        return productService.listAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id){
        try {
            Product product = productService.getProduct(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Product product){
        try {
            productService.saveProduct(product);
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Product product, @PathVariable Integer id){
        try{
            Product existingProduct = productService.getProduct(id);
            product.setId(id);
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

}
