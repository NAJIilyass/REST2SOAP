package hh.ma.ac.inpt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.domaine.ProductsWrapper;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hh.ma.ac.inpt.service.ProductManager")
public class ProductsManagerImpl implements ProductManager {

    private static long nextProductId = 0;
    private static List<Product> products = new ArrayList<Product>();

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
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        throw new NoSuchProductException("No Such Product");
    }

}
