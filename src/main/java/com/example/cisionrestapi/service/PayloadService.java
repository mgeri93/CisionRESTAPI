package com.example.cisionrestapi.service;

import com.example.cisionrestapi.domain.Payload;
import com.example.cisionrestapi.domain.PayloadDTO;

import java.util.List;
import java.util.Optional;

public interface PayloadService {

    Optional<Payload> findPayloadById(long id);

    Iterable<PayloadDTO> list();

    Payload save(Payload payload);

    Iterable<Payload> save(List<Payload> payloadList);

    int longestPalSize(String content);

}
