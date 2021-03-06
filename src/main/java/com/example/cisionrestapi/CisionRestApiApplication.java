package com.example.cisionrestapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.example.cisionrestapi.domain.Payload;
import com.example.cisionrestapi.service.PayloadServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class CisionRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CisionRestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PayloadServiceImpl payloadServiceImpl){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Payload>> typeReference = new TypeReference<>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/payload.json");
            try{
                List<Payload> validList = mapper.readValue(inputStream,typeReference)
                        .stream()
                        .filter(Payload::isValid)
                        .collect(Collectors.toList());
                payloadServiceImpl.save(validList);
                System.out.println("Data Saved to database!");
            } catch (IOException e){
                System.out.println("Unable to save data: " + e.getMessage());
            }
        };
    }

}
