package com.example.cisionrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private Timestamp timestamp;

    public Payload(){}


}
