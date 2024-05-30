package hh.ma.ac.inpt.translationLayer;

import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import hh.ma.ac.inpt.exceptions.RequestException;
import hh.ma.ac.inpt.service.ProductManager;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hh.ma.ac.inpt.service.ProductManager")
public class SoapRestTranslationLayer implements ProductManager {

    private static final String REST_ENDPOINT_URL = "http://localhost:8080/products";

    @Override
    public long addProduct(Product product) throws RequestException {
        Long addedProductId = SoapRestUtility.sendPostRequest(REST_ENDPOINT_URL, product, Long.class);
        return addedProductId;
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        return SoapRestUtility.sendGetRequest(REST_ENDPOINT_URL + "/" + id, Product.class);
    }

    @Override
    public boolean updateProduct(long id, Product product) throws NoSuchProductException {
        return SoapRestUtility.sendPutRequest(REST_ENDPOINT_URL + "/" + id, product, Product.class);
    }

}