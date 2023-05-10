package com.example.shoplist.service;

import com.example.shoplist.ShopListApplication;
import com.example.shoplist.exeption.NotFoundException;
import com.example.shoplist.model.Product;
import com.example.shoplist.repository.ProductRepository;
//import com.example.shoplist.util.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShopListService {
    private List<Product> shopList;
  //  private final ProductDAO productDAO;

    @Autowired
    ProductRepository productRepository;
   public ShopListService(){
     //   shopList = new ArrayList<>();
    //    addProduct(new Product("milk"));
   //     addProduct(new Product("apple"));
    //    addProduct("peach");
     //   productDAO = new ProductDAO();
    }

    public Product getProduct(Long id){
        //return productDAO.getProduct(id);
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {

            return productOpt.get();
        } else {
            throw new NotFoundException();
        }
    }
    public List<Product> getShopList(){

        //return productDAO.getAll();
        return productRepository.findAll();
    }

 /*   public void addProduct(String name){
        shopList.add(new Product(shopList.size() + 1, name));
    }*/
    public Product addProduct(Product product){
        // shopList.add(product);
      //  productDAO.save(product);
        productRepository.save(product);
        return product;
    }
    public void deleteProduct(Long id){
      //  Product product = productDAO.getProduct(id);
      //  productDAO.delete(product);
        //shopList.removeIf(product -> product.getId() == id);
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id) {
   /*     Product product = productDAO.getProduct(id);
        if(product != null){
            product.setBought(!product.isBought());
            productDAO.update(product);
            return product;
        }else {
            throw new NotFoundException();
        }*/
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setBought(!product.isBought());

            return productRepository.save(product);
        } else {
            throw new NotFoundException();
        }
    }

 /*   public Product findById(Integer id){
        for(Product product: shopList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }*/
}
