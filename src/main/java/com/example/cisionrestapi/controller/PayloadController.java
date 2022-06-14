package com.example.cisionrestapi.controller;

import com.example.cisionrestapi.domain.Payload;
import com.example.cisionrestapi.service.PayloadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payload")
public class PayloadController {

    private PayloadService payloadService;

    public PayloadController(PayloadService payloadService) {
        this.payloadService = payloadService;
    }

    @GetMapping("/list")
    public Iterable<Payload> list(){
        return payloadService.list();
    }

}
