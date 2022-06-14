package com.example.cisionrestapi.domain;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


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
    public Payload(){}
}
