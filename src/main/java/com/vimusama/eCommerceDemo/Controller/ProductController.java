package com.vimusama.eCommerceDemo.Controller;

import java.util.List ;
import java.util.Optional;

import com.vimusama.eCommerceDemo.Service.ProductService;
import com.vimusama.eCommerceDemo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService ;

    @GetMapping("/products")
    private List<Product> getProducts(){
        return productService.getProducts() ;
    }

    @GetMapping("/products/{prodId}")
    private Optional<Product> getSpecificProduct(@PathVariable int prodId){
        return productService.getSpecificProduct(prodId) ;
    }

    @PostMapping("/products/new")
    private void storeProduct(@RequestBody Product prod){
        productService.addProducts(prod);
    }

    @PutMapping("/products/update")
    private void updateProduct(@RequestBody Product prod){
        productService.updateProduct(prod) ;
    }

    @DeleteMapping("/products/delete/{id}")
    private void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id) ;
    }
}
