package com.example.shoplist.controller;

import com.example.shoplist.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/shopList")
public class DeletionController {
    @Autowired
    ShopListService shopList;

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam(name = "id") Integer id){
        shopList.deleteProduct(id);
        return new RedirectView("/shopList/show");
    }
}
