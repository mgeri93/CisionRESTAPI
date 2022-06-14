package com.example.cisionrestapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.example.cisionrestapi.domain.Payload;
import com.example.cisionrestapi.service.PayloadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CisionRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CisionRestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PayloadService payloadService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Payload>> typeReference = new TypeReference<List<Payload>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/payload.json");
            try{
                List<Payload> payloadList = mapper.readValue(inputStream,typeReference);
                payloadService.save(payloadList);
                System.out.println("Data Saved to database!");
            } catch (IOException e){
                System.out.println("Unable to save data: " + e.getMessage());
            }
        };
    }

}
