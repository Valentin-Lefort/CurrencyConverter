package org.currency.currencyconverter.component;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ApiCall {
  
  ApiComponent apiComponent;
  
  public ApiCall(ApiComponent apiComponent) {
    this.apiComponent = apiComponent;
  }
  public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws JSONException {
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.freecurrencyapi.com/v1/latest?apikey=" + apiComponent.getAccess_key() + "&currencies=" + toCurrency + "&base_currency=" + fromCurrency))
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
    HttpResponse<String> response = null;
    try {
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    assert response != null;
    JSONObject jsonObject = new JSONObject(response.body());
    JSONObject rates = jsonObject.getJSONObject("data");
    System.out.println(rates);
    double exchangeRate = rates.getDouble(toCurrency);
    return amount * exchangeRate;
  }
}