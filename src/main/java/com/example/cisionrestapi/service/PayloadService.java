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
        payload.setLongestPalindromeSize(longestPalSize(payload.getContent()));
        return payloadRepository.save(payload);
    }

    public Iterable<Payload> save(List<Payload> payloadList){
        for(Payload payload : payloadList){
            payload.setLongestPalindromeSize(longestPalSize(payload.getContent()));
        }
        return payloadRepository.saveAll(payloadList);
    }

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
