package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") long id){


        return productService.getProduct(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("time", ""+LocalDateTime.now());
        httpHeaders.add("Operation","GetMethod");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(productService.getProducts());

    }

    @PostMapping
    public  ResponseEntity<List<Product>> createProduct(@RequestBody Product product){

        List<Product> productList = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("time",""+ LocalTime.now())
                .body(productList);
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") long id){

        MultiValueMap<String,String>map = new LinkedMultiValueMap<>();
        map.add("version","v1");
        map.add("time",""+LocalTime.now());




        return new ResponseEntity<>(productService.delete(id),map,HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id,@RequestBody Product product){

        MultiValueMap<String,String>map = new LinkedMultiValueMap<>();
        map.add("version","v1");
        map.add("time",""+LocalTime.now());
        map.add("operation","update");

        List<Product> productList = productService.updateProduct(id,product);


        return new ResponseEntity<>(productList,map,HttpStatus.OK);
    }



    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts(){

        return ResponseEntity
                .ok(new ResponseWrapper
                        ("product successfully retrieve",
                                productService.getProducts()
                        )
                );
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") long id){
        return ResponseEntity.ok(new ResponseWrapper("project is deleted"));
    }


    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> delete2Id(@PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.OK)
                .header("operation","delete")
                .body(new ResponseWrapper("product is deleted"));
    }

}


























