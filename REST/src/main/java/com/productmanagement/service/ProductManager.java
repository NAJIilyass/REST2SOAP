package com.productmanagement.service;

import com.productmanagement.exception.NoSuchProductException;
import com.productmanagement.model.Product;
import java.util.List;
public interface ProductManager  {

    public long addProduct(Product product) throws NoSuchProductException;

    public Product getProduct(long id) throws NoSuchProductException;

    public void updateProduct(long id,Product product) throws NoSuchProductException;

    public void deleteProduct(long id) throws NoSuchProductException;

    public List<Product> getProductsByTag(String tag) throws NoSuchProductException;

}
