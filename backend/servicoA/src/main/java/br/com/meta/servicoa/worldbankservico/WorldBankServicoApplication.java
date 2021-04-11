package br.com.meta.servicoa.worldbankservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WorldBankServicoApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(WorldBankServicoApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/resource/*").allowedMethods("GET");
    }
}
