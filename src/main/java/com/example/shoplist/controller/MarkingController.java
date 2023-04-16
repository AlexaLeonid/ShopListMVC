package com.example.shoplist.controller;

import com.example.shoplist.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/shopList")
public class MarkingController {

    @Autowired
    ShopListService shopList;

    @GetMapping("/mark")
    public RedirectView mark(@RequestParam(name = "id") Integer id){
        shopList.markElement(id);
        return new RedirectView("/shopList/show");
    }
}
