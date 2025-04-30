package com.vimusama.eCommerceDemo.Service;

import com.vimusama.eCommerceDemo.Model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductService {
    private ArrayList<Product> products ;

    public ProductService(){
        this.products = new ArrayList<>() ;
        this.addProducts(new Product(101, "Table", 10000));
        this.addProducts(new Product(102, "Laptop", 80000));
        this.addProducts(new Product(103, "Water Bottle", 800));
        this.addProducts(new Product(104, "Ipad", 72000));
    }

    public void addProducts(Product product){
        this.products.add(product) ;
    }

    public ArrayList<Product> getProducts(){
        return this.products ;
    }
}
