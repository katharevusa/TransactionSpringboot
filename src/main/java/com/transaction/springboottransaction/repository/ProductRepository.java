package com.transaction.springboottransaction.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.springboottransaction.models.Product;
public interface ProductRepository extends JpaRepository<Product, Long>{

}
