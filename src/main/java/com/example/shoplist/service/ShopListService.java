package com.example.shoplist.service;

import com.example.shoplist.ShopListApplication;
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
    }

    public List<Product> getShopList(){
        return shopList;
    }

    public void addProduct(String name){
        shopList.add(new Product(shopList.size() + 1, name));
    }

    public void deleteProduct(Integer id){
        shopList.removeIf(product -> product.getId() == id);
    }

    public void markElement(Integer id){
        for(Product product: shopList){
            if(product.getId() == id){
                product.setBought(!product.isBought());
            }
        }
    }
}
