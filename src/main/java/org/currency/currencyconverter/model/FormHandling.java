package org.currency.currencyconverter.model;

public class FormHandling {
  
  private String fromCurrency;
  private String toCurrency;
  private String amount;
  private String result;
  
  public void setFromCurrency(String fromCurrency) {
    this.fromCurrency = fromCurrency;
  }
  
  public void setToCurrency(String toCurrency) {
    this.toCurrency = toCurrency;
  }
  
  public void setAmount(String amount) {
    this.amount = amount;
  }
  
  public void setResult(String result) {
    this.result = result;
  }
  
  public String getFromCurrency() {
    return fromCurrency;
  }
  
  public String getToCurrency() {
    return toCurrency;
  }
  
  public String getAmount() {
    return amount;
  }
  
  public String getResult() {
    return result;
  }
  
}
