package com.studentmanagment.controller;

import com.studentmanagment.service.ProductManager;
import com.studentmanagment.exception.NoSuchProductException;
import com.studentmanagment.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductManager productService;

    @PostMapping
    public long addProduct(@RequestBody Product product) throws NoSuchProductException {
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) throws NoSuchProductException {
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) throws NoSuchProductException {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable long id, @RequestBody Product product) throws NoSuchProductException {
        productService.updateProduct(id,product);
    }
}
