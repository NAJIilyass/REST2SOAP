package hh.ma.ac.inpt.service;

import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.domaine.ProductsWrapper;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import hh.ma.ac.inpt.exceptions.RequestException;
import hh.ma.ac.inpt.translationLayer.SoapRestUtility;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC)

public interface ProductManager {
	
	@WebMethod
	@WebResult(name = "productId")
	long addProduct(@WebParam(name = "product") Product product) throws NoSuchProductException, RequestException;

	@WebMethod
	@WebResult(name = "product")
	Product getProduct(@WebParam(name = "productId") long id) throws NoSuchProductException;

	@WebMethod
	boolean updateProduct(@WebParam(name = "productId") long id,@WebParam(name = "product") Product product) throws NoSuchProductException;

	@WebMethod
	ArrayList<Product> getProductsByTag(@WebParam(name = "tag") String tag) throws NoSuchProductException;

}
