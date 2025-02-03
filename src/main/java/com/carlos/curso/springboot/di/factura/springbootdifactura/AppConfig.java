package com.carlos.curso.springboot.di.factura.springbootdifactura;

import com.carlos.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.carlos.curso.springboot.di.factura.springbootdifactura.models.Product;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySources({
  @PropertySource("classpath:data.properties")
})
public class AppConfig {

  @Bean("default")
//  @Primary
  List<Item> itemsInvoice() {
    return Arrays.asList(
      new Item(new Product("Camara Sony", 800), 2),
      new Item(new Product("Bicicleta Bianchi 26", 1200), 4)
    );
  }

  @Bean
  List<Item> itemsInvoiceOffice() {
    return Arrays.asList(
      new Item(new Product("Monitor Asus 24", 700), 4),
      new Item(new Product("Notebook Razer", 2400), 6),
      new Item(new Product("Impresora HP", 800), 1),
      new Item(new Product("Escritorio", 900), 4)
    );
  }

}
