package com.carlos.curso.springboot.di.factura.springbootdifactura;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
  @PropertySource("classpath:data.properties")
})
public class AppConfig {
}
