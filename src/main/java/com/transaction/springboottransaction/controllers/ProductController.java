package com.transaction.springboottransaction.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.springboottransaction.models.Product;
import com.transaction.springboottransaction.repository.*;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	  public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String title) {
	    try {
	      List<Product> products = new ArrayList<Product>();
	      products = productRepository.findAll();
	      if (products.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(products, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	@GetMapping("/products/{id}")
	  public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
	    Optional<Product> productDetail = productRepository.findById(id);

	    if (productDetail.isPresent()) {
	      return new ResponseEntity<>(productDetail.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
