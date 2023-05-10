package com.example.shoplist.service;

import com.example.shoplist.exeption.NotFoundException;
import com.example.shoplist.model.Product;
import com.example.shoplist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopListService {
    @Autowired
    ProductRepository productRepository;
   public ShopListService(){

   }

    public Product getProduct(Long id){

        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {

            return productOpt.get();
        } else {
            throw new NotFoundException();
        }
    }
    public List<Product> getShopList(){

        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        productRepository.save(product);
        return product;
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setBought(!product.isBought());

            return productRepository.save(product);
        } else {
            throw new NotFoundException();
        }
    }

}
