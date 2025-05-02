package com.vimusama.eCommerceDemo.Service;
import com.vimusama.eCommerceDemo.Model.Product;
import com.vimusama.eCommerceDemo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepo databaseRepo ;

    public ProductService(){
    }

    public void addProducts(Product product){
        databaseRepo.save(product) ;
    }

    public List<Product> getProducts(){
        return databaseRepo.findAll();
    }

    public Optional<Product> getSpecificProduct(int id){
        return databaseRepo.findById(id) ;
    }

    public void updateProduct(Product p){
        databaseRepo.save(p) ;
    }

    public Optional<Product> deleteProduct(int id) {
        Optional<Product> prod = databaseRepo.findById(id) ;
        if(prod.isPresent()) {
            databaseRepo.deleteById(id);
        }
        return prod ;
    }
}
