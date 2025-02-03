package com.carlos.curso.springboot.di.factura.springbootdifactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

  private Client client;

  @Value("${invoice.description}")
  private String description;

  private List<Item> items;

  @PostConstruct
  public void init() {
    System.out.println("Creando componenete de la factura");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Destruyendo componente o bean invoice");
  }

  public Client getClient() {
    return client;
  }

  @Autowired
  public void setClient(Client client) {
    this.client = client;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Item> getItems() {
    return items;
  }

  @Autowired
  @Qualifier("default")
  public void setItems(List<Item> items) {
    this.items = items;
  }

  public int getTotal() {
//    int total = 0;
//    for (Item item : this.items) {
//      total += item.getImport();
//    }
//    return total;
    return items.stream()
      .map(Item::getImport)
      .reduce(0, (sum, item) -> sum + item);
  }
}
