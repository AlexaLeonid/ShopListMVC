package com.example.shoplist.controller;

import com.example.shoplist.model.Product;
import com.example.shoplist.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopList")
public class ShopListController {

    @Autowired
    ShopListService shopList;

    @GetMapping("/")
    public List<Product> show(){
        return shopList.getShopList();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") Integer id){
        return shopList.findById(id);
    }

    @PostMapping("/add")
    public Product create(@RequestBody Product product) {
        return shopList.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable(value = "id") Integer id) {
        return shopList.updateProduct(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        shopList.deleteProduct(id);
    }
}
