package org.currency.currencyconverter.component;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCall {
  public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws JSONException {
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://api.exchangeratesapi.io/v1/latest"))
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
    double exchangeRate = jsonObject.getJSONObject("rates").getDouble(toCurrency);
    return amount * exchangeRate;
  }
}
