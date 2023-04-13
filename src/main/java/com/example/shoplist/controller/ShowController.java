package com.example.shoplist.controller;

import com.example.shoplist.model.Product;
import com.example.shoplist.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopList")
public class ShowController {

    @Autowired
    ShopListService shopList;

  //  @GetMapping("/show")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public List<Product> show(){
        return shopList.getShopList();
    }
}
