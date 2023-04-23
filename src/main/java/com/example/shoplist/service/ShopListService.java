package com.example.shoplist.service;

import com.example.shoplist.ShopListApplication;
import com.example.shoplist.exeption.NotFoundException;
import com.example.shoplist.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShopListService {
    private List<Product> shopList;

    public ShopListService(){
        shopList = new ArrayList<>();
        addProduct("milk");
        addProduct("apple");
        addProduct("peach");
    }

    public List<Product> getShopList(){
        return shopList;
    }

    public void addProduct(String name){
        shopList.add(new Product(shopList.size() + 1, name));
    }
    public Product addProduct(Product product){
        shopList.add(product);
        return product;
    }
    public void deleteProduct(Integer id){
        shopList.removeIf(product -> product.getId() == id);
    }

    public Product updateProduct(Integer id) {
        Product product = findById(id);
        if(product != null){
            product.setBought(!product.isBought());
            return product;
        }else {
            throw new NotFoundException();
        }
    }

    public Product findById(Integer id){
        for(Product product: shopList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
