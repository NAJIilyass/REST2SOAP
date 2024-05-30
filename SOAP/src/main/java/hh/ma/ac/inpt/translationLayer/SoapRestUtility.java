package hh.ma.ac.inpt.translationLayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import hh.ma.ac.inpt.exceptions.RequestException;
import okhttp3.*;

import java.io.IOException;

public class SoapRestUtility {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final OkHttpClient httpClient = new OkHttpClient();

    public static <T> T sendPostRequest(String url, Object requestBody, Class<T> responseClass) throws RequestException {
        try {
            String jsonRequestBody = objectMapper.writeValueAsString(requestBody);
            System.out.println("Request JSON: " + jsonRequestBody); // Log request JSON
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonRequestBody);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = httpClient.newCall(request).execute();
            System.out.println("Request generated: " + request);
            System.out.println("Response from the rest backend: " + response);
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                System.out.println("Response JSON: " + responseBody); // Log response JSON

                if (responseClass == Long.class) {
                    return responseClass.cast(Long.valueOf(responseBody));
                } else {
                    return objectMapper.readValue(responseBody, responseClass);
                }
            } else {
                throw new RequestException("Failed to process POST request: " + response.message());
            }
        } catch (IOException e) {
            throw new RequestException("Failed to process POST request: " + e.getMessage());
        }
    }

    public static <T> T sendGetRequest(String url, Class<T> responseClass) throws NoSuchProductException {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = httpClient.newCall(request).execute();

            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, responseClass);
            } else {
                throw new NoSuchProductException("Failed to process GET request");
            }
        } catch (IOException e) {
            throw new NoSuchProductException("Failed to process GET request: " + e.getMessage());
        }
    }

    public static boolean sendPutRequest(String url, Object requestBody, Class<Product> productClass) throws NoSuchProductException {
        try {
            String jsonRequestBody = objectMapper.writeValueAsString(requestBody);
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonRequestBody);
            Request request = new Request.Builder()
                    .url(url)
                    .put(body)
                    .build();
            Response response = httpClient.newCall(request).execute();

            if (response.isSuccessful()) {
                // Close the response body if it exists
                if (response.body() != null) {
                    response.body().close();
                }
                return true;
            } else {
                // Close the response body if it exists
                if (response.body() != null) {
                    response.body().close();
                }
                throw new NoSuchProductException("Failed to process PUT request: " + response.message());
            }
        } catch (IOException e) {
            throw new NoSuchProductException("Failed to process PUT request: " + e.getMessage());
        }
    }

}