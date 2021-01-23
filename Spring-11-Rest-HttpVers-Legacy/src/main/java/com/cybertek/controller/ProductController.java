package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") long id){

        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts(){
        return productService.getProducts();
    }

    //create product
    //delete product
    //update product

}
