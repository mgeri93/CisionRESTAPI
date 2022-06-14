package com.example.cisionrestapi.service;

import com.example.cisionrestapi.domain.Payload;
import com.example.cisionrestapi.repository.PayloadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayloadService {

    private PayloadRepository payloadRepository;

    public PayloadService(PayloadRepository payloadRepository) {
        this.payloadRepository = payloadRepository;
    }

    public Iterable<Payload> list() {
        return payloadRepository.findAll();
    }

    public Payload save(Payload payload){
        return payloadRepository.save(payload);
    }

    public Iterable<Payload> save(List<Payload> payloadList){
        return payloadRepository.saveAll(payloadList);
    }

}
