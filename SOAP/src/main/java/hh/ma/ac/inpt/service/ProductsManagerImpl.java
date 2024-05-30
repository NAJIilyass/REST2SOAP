package hh.ma.ac.inpt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.domaine.ProductsWrapper;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hh.ma.ac.inpt.service.ProductManager")
public class ProductsManagerImpl {

//    private static long nextProductId = 0;
//    private static List<Product> products = new ArrayList<>();
//
//    @Override
//    public long addProduct(Product product) {
//        // Generate a new ID for the product
//        nextProductId++;
//        product.setId(nextProductId);
//        products.add(product);
//        return product.getId();
//    }
//
//    @Override
//    public Product getProduct(long id) throws NoSuchProductException {
//        for (Product product : products) {
//            if (id == product.getId()) {
//                return product;
//            }
//        }
//        throw new NoSuchProductException("No Such Product");
//    }
//
//    @Override
//    public void updateProduct(Product product) throws NoSuchProductException {
//        boolean found = false;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == product.getId()) {
//                products.set(i, product);
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            throw new NoSuchProductException("No Such Product");
//        }
//    }
//
//    @Override
//    public void deleteProduct(long id) throws NoSuchProductException {
//        Iterator<Product> iterator = products.iterator();
//        boolean found = false;
//        while (iterator.hasNext()) {
//            Product product = iterator.next();
//            if (product.getId() == id) {
//                iterator.remove();
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            throw new NoSuchProductException("No Such Product");
//        }
//    }
}
