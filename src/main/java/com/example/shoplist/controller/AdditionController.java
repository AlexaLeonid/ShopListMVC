package com.example.shoplist.controller;

import com.example.shoplist.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/shopList")
//@RequestMapping("/")
public class AdditionController {

    @Autowired
    ShopListService shopList;

    @GetMapping("/add")
    public RedirectView add(@RequestParam String name){
        shopList.addProduct(name);
        return new RedirectView("/shopList/show");
    }
}
