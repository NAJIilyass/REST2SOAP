package com.studentmanagment.service;

import com.studentmanagment.exception.NoSuchProductException;
import com.studentmanagment.model.Product;

public interface ProductManager  {

    public long addProduct(Product product) throws NoSuchProductException;

    public Product getProduct(long id) throws NoSuchProductException;


}
