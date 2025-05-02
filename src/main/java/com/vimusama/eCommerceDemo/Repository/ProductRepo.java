package com.vimusama.eCommerceDemo.Repository;

import com.vimusama.eCommerceDemo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaParameters;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
