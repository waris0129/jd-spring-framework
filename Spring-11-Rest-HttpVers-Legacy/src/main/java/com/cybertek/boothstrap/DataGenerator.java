package com.cybertek.boothstrap;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        Product pc1 = new Product("DELL");
        Product pc2 = new Product("APPLE");
        Product pc3 = new Product("MacBook");
        Product pc4 = new Product("Iphone");
        Product pc5 = new Product("Ipad");

        productService.createProduct(pc1);
        productService.createProduct(pc2);
        productService.createProduct(pc3);
        productService.createProduct(pc4);
        productService.createProduct(pc5);
    }
}
