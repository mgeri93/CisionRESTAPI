package com.example.cisionrestapi.controller;

import com.example.cisionrestapi.domain.PayloadDTO;
import com.example.cisionrestapi.service.PayloadServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PayloadController {

    private PayloadServiceImpl payloadServiceImpl;

    public PayloadController(PayloadServiceImpl payloadServiceImpl) {
        this.payloadServiceImpl = payloadServiceImpl;
    }

    @GetMapping("/list")
    public Iterable<PayloadDTO> list(){
        return payloadServiceImpl.list();
    }

}
