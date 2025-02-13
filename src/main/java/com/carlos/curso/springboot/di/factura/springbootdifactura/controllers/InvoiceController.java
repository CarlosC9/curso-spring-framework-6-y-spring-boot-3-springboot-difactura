package com.carlos.curso.springboot.di.factura.springbootdifactura.controllers;

import com.carlos.curso.springboot.di.factura.springbootdifactura.models.Client;
import com.carlos.curso.springboot.di.factura.springbootdifactura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

  @Autowired
  private Invoice invoice;

  @GetMapping("/show")
  public Invoice show() {
    Invoice i = new Invoice();
    Client c = new Client();

    c.setName(this.invoice.getClient().getName());
    c.setLastName(this.invoice.getClient().getLastName());
    i.setClient(c);
    i.setDescription(this.invoice.getDescription());
    i.setItems(this.invoice.getItems());
    return i;
  }

}
