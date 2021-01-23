package com.cybertek.implementation;

import com.cybertek.entity.Product;
import com.cybertek.repository.ProductRepository;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> delete(Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @Override
    public List<Product> updateProduct(Long id, Product product) {

         Product product1 = productRepository.findById(id).get();

         product1.setName(product.getName());

         productRepository.save(product1);

        return productRepository.findAll();
    }

    @Override
    public List<Product> createProduct(Product product) {

        productRepository.save(product);

        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {

        return productRepository.findById(id).get();

    }
}
