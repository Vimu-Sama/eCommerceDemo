package com.vimusama.eCommerceDemo.Service;
import com.vimusama.eCommerceDemo.Model.Product;
import com.vimusama.eCommerceDemo.Repository.ProductRepo;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepo databaseRepo ;

    public ProductService(){
    }

    public Product addProducts(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        byte[] a = imageFile.getBytes() ;
        product.setImageData(a);
        return databaseRepo.save(product) ;
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

    public ResponseEntity<byte []> fetchProductImage(int id){
        Optional<Product> prod = databaseRepo.findById(id) ;
        if(prod.isPresent()){
            Product product = prod.get() ;
            byte[] imageFile = product.getImageData() ;
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(product.getImageType()))
                    .body(imageFile);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
    }
}
