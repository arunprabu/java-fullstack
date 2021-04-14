package com.examples.scart.service;

import com.examples.scart.model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private static Map<String, Product> productRepo = new HashMap<>();

//    @Autowired
//    ProductRepository productRepo;

    public Collection<Product> getProducts() {
        return productRepo.values();
//        return productRepo.findAll();
    }

    public void createProduct(Product product) {
        if(product.getId() == null || product.getId().isEmpty()) {
            throw new RuntimeException("Product Id mandatory");
        }
        productRepo.put(product.getId(), product);
//        productRepo.save(product);
    }

    public void updateProduct(String id, Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
//        product.setId(id);
//        productRepo.save(product);
    }

    public void deleteProduct(String id) {
        productRepo.remove(id);
//        productRepo.delete(productRepo.findById(id).get());
    }

    public Product getProduct(String id) {
        return productRepo.get(id);
//        return productRepo.findById(id).get();
    }

    public void clear() {
        productRepo.clear();
    }

}