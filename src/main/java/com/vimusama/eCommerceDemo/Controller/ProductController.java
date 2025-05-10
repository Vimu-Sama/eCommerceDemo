package com.vimusama.eCommerceDemo.Controller;

import java.util.List ;
import java.util.Optional;

import com.vimusama.eCommerceDemo.Service.ProductService;
import com.vimusama.eCommerceDemo.Model.Product;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService ;

    @GetMapping("/products")
    private List<Product> getProducts(){
        return productService.getProducts() ;
    }

    @GetMapping("/product/{prodId}")
    private Optional<Product> getSpecificProduct(@PathVariable int prodId){
        return productService.getSpecificProduct(prodId) ;
    }

    @GetMapping("/product/{id}/image")
    private ResponseEntity<byte[]> fetchImage(@PathVariable int id){
        return productService.fetchProductImage(id) ;
    }

    @PostMapping("/products/new")
    private ResponseEntity<?> storeProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product prod = productService.addProducts(product, imageFile);
            return new ResponseEntity<>(prod,HttpStatus.CREATED) ;
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }
    @PutMapping("/product/update/{id}")
    private ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile){
        System.out.println("The api was called for id-> " + id) ;
        try{
            return productService.updateProduct(id, product, imageFile) ;
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

    @DeleteMapping("/products/delete/{id}")
    private ResponseEntity deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id) ;
    }
}
