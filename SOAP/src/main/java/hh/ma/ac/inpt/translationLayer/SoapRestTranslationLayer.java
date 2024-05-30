package hh.ma.ac.inpt.translationLayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.domaine.ProductsWrapper;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import hh.ma.ac.inpt.service.ProductManager;
import jakarta.jws.WebService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import okhttp3.*;

import java.io.IOException;
import java.io.StringWriter;

@WebService(endpointInterface = "hh.ma.ac.inpt.service.ProductManager")
public class SoapRestTranslationLayer implements ProductManager {

    private static final String REST_ENDPOINT_URL = "http://localhost:8080/products";

    private final ObjectMapper objectMapper;
    private final OkHttpClient httpClient;

    public SoapRestTranslationLayer() {
        this.objectMapper = new ObjectMapper();
        this.httpClient = new OkHttpClient();
    }

    @Override
    public long addProduct(Product product) throws NoSuchProductException {
        try {
            // Convert the product to JSON
            String jsonProduct = objectMapper.writeValueAsString(product);

            System.out.printf("Product : %s", product);
            // Make REST POST request to add the product
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonProduct);
            Request request = new Request.Builder()
                    .url(REST_ENDPOINT_URL)
                    .post(body)
                    .build();
            Response response = httpClient.newCall(request).execute();


            System.out.printf("body : %s", body);
            System.out.print("request : ");
            System.out.println(request);
            System.out.print("response : ");
            System.out.println(response);

            // Check if the product was successfully added
            if (response.isSuccessful()) {
                // Parse the response to get the product ID
                String responseBody = response.body().string();
                long productId = Long.parseLong(responseBody);

                System.out.printf("responseBody : %s", responseBody);

                // Create a SOAP response object
                ProductsWrapper soapResponse = new ProductsWrapper();
                //soapResponse.setProductId(productId);

                // Convert the SOAP response object to XML
                StringWriter sw = new StringWriter();
                JAXBContext jaxbContext = JAXBContext.newInstance(ProductsWrapper.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(soapResponse, sw);
                String soapResponseXml = sw.toString();

                // Log SOAP response XML for debugging
                System.out.println("SOAP Response XML: " + soapResponseXml);
                System.out.println("SOAP Response XML: " + soapResponseXml.toString());
//                System.out.println("SOAP final output : " + product);


                // Return the product ID
                return productId;
            } else {
                throw new NoSuchProductException("Failed to add product via REST");
            }
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (IOException | JAXBException e) {
            throw new NoSuchProductException("Failed to add product via REST: " + e.getMessage());
        }
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        try {
            // Make REST GET request to retrieve the product
            Request request = new Request.Builder()
                    .url(REST_ENDPOINT_URL + "/" + id)
                    .get()
                    .build();
            Response response = httpClient.newCall(request).execute();

            // Check if the product was found
            if (response.isSuccessful()) {
                // Parse the JSON response body to get the product
                String responseBody = response.body().string();
                Product product = objectMapper.readValue(responseBody, Product.class);

                // Log SOAP response for debugging
                System.out.println("SOAP Response: " + product);

                // Return the product
                return product;
            } else {
                throw new NoSuchProductException("Product not found via REST");
            }
        } catch (IOException e) {
            throw new NoSuchProductException("Failed to retrieve product via REST: " + e.getMessage());
        }
    }

}
