package com.example.cisionrestapi.service;

import com.example.cisionrestapi.domain.Payload;
import com.example.cisionrestapi.domain.PayloadDTO;
import com.example.cisionrestapi.repository.PayloadRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PayloadServiceImpl implements PayloadService {

    private PayloadRepository payloadRepository;

    public PayloadServiceImpl(PayloadRepository payloadRepository) {
        this.payloadRepository = payloadRepository;
    }

    @Override
    public Optional<Payload> findPayloadById(long id){
        return payloadRepository.findById(id);
    }

    @Override
    public Iterable<PayloadDTO> list(){
        List<PayloadDTO> payloadDTOS = new ArrayList<>();
        for(Payload payload : payloadRepository.findAll()){
            payloadDTOS.add(new PayloadDTO(payload.getContent(),
                    payload.getTimestamp(),
                    payload.getLongestPalindromeSize()));
        }
        return payloadDTOS;
    }

    @Override
    public Payload save(@NotNull Payload payload){
        payload.setLongestPalindromeSize(longestPalSize(payload.getContent()));
        return payloadRepository.save(payload);
    }

    @Override
    public Iterable<Payload> save(@NotNull List<Payload> payloadList){
        for(Payload payload : payloadList){
                payload.setLongestPalindromeSize(
                        longestPalSize(payload.getContent())
                );
        }
        return payloadRepository.saveAll(payloadList);
    }

    @Override
    public int longestPalSize(String content){
        int n = content.length();
        if (n < 2)
            return n;

        int maxLength = 1,start=0;
        int low, high;
        for(int i = 0; i < n; i++) {
            if (!Character.isDigit(content.charAt(i))) {
                low = i - 1;
                high = i + 1;
                while (high < n && content.charAt(high) == content.charAt(i))
                    high++;

                while (low >= 0 && content.charAt(low) == content.charAt(i))
                    low--;

                while (low >= 0 && high < n && content.charAt(low) == content.charAt(high)) {
                    low--;
                    high++;
                }

                int length = high - low - 1;
                if (maxLength < length) {
                    maxLength = length;
                    start = low + 1;
                }
            }
        }
        return maxLength;
    }

}
