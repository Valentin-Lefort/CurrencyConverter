package org.currency.currencyconverter.controller;

import org.currency.currencyconverter.component.ApiCall;
import org.currency.currencyconverter.component.ApiComponent;
import org.currency.currencyconverter.model.FormHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
  
  @Autowired
  private ApiComponent apiComponent;
  
  @Autowired
  private ApiCall apiCall;
  
  @GetMapping(value = "/")
  public String homepage(Model model) {
    model.addAttribute("formHandling", new FormHandling());
    return "index";
  }
  
  @PostMapping(value = "/")
  public String homepagePost(@ModelAttribute FormHandling formHandling, Model model) {
    String fromCurrency = formHandling.getFromCurrency();
    String toCurrency = formHandling.getToCurrency();
    double amount = Double.parseDouble(formHandling.getAmount());
    
    double convertedAmount = apiCall.convertCurrency(fromCurrency, toCurrency, amount);
    formHandling.setResult(String.valueOf(convertedAmount));
    
    
    model.addAttribute("formHandling", formHandling);
    return "index";
  }
}
