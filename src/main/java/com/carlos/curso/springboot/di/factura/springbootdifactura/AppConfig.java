package com.carlos.curso.springboot.di.factura.springbootdifactura;

import com.carlos.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.carlos.curso.springboot.di.factura.springbootdifactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySources({
  @PropertySource("classpath:data.properties")
})
public class AppConfig {

  @Bean
  List<Item> itemsInvoice() {
    return Arrays.asList(
      new Item(new Product("Camara Sony", 800), 2),
      new Item(new Product("Bicicleta Bianchi 26", 1200), 4)
    );
  }

}
