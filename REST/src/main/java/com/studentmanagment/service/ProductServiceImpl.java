package com.studentmanagment.service;

import com.studentmanagment.exception.NoSuchProductException;
import com.studentmanagment.model.Product;
import com.studentmanagment.service.ProductManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductManager {

    private static long nextProductId = 0;
    private static List<Product> products = new ArrayList<>();

    @Override
    public long addProduct(Product product) {
        // Generate a new ID for the product
        nextProductId++;
        product.setId(nextProductId);
        products.add(product);
        return product.getId();
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchProductException("No Such Product"));
    }
}
