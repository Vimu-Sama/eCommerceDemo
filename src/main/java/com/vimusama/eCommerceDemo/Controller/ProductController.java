package com.vimusama.eCommerceDemo.Controller;

import java.util.ArrayList ;
import com.vimusama.eCommerceDemo.Service.ProductService;
import com.vimusama.eCommerceDemo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService ;

    @RequestMapping("/products")
    private ArrayList<Product> getProducts(){
        return productService.getProducts() ;
    }

}
