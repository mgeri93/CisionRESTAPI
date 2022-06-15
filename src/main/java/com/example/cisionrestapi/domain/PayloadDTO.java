package com.example.cisionrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayloadDTO {

    private String content;
    private String timestamp;
    private int longest_palindrome_size;

    public PayloadDTO(){};

}
