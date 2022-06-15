package com.example.cisionrestapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private String timestamp;
    private int longestPalindromeSize;

    public boolean isValid(){
        return this.content.length() > 0 && this.timestamp.length() > 0;
    }

    public Payload(){}
}
