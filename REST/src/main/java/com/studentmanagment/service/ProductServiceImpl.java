package com.studentmanagment.service;

import com.studentmanagment.exception.NoSuchProductException;
import com.studentmanagment.model.Product;
import com.studentmanagment.service.ProductManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductManager {

    private static long nextProductId = 0;
    private static List<Product> products = new ArrayList<>();

    @Override
    public long addProduct(Product product) {
        if (product.getId() == 0) {
            // Generate a new ID for the product if not provided
            product.setId(nextProductId++);
        }
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

    @Override
    public void updateProduct(long id,Product product) throws NoSuchProductException {
        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoSuchProductException("No Such Product");
        }
    }

    @Override
    public void deleteProduct(long id) throws NoSuchProductException {
        Iterator<Product> iterator = products.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoSuchProductException("No Such Product");
        }
    }
}
