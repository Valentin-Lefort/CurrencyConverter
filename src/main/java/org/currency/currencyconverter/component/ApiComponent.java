package org.currency.currencyconverter.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiComponent {
  
  @Value("${access_key}")
  private String access_key;
  
  public String getAccess_key() {
    return access_key;
  }
}
