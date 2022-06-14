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

    public Payload(Long id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.longestPalindromeSize = longestPalSize(content);
    }

    public Payload(){}

    public int longestPalSize(String content){
        int n = content.length();
        if (n < 2)
            return n;

        int maxLength = 1,start=0;
        int low, high;
        for(int i = 0; i < n; i++){
            low = i - 1;
            high = i + 1;
            while(high < n && content.charAt(high) == content.charAt(i))
                high++;

            while(low >= 0 && content.charAt(low) == content.charAt(i))
                low--;

            while(low >= 0 && high < n && content.charAt(low) == content.charAt(high)){
                low--;
                high++;
            }

            int length = high - low - 1;
            if(maxLength < length){
                maxLength = length;
                start=low+1;
            }
        }
        return maxLength;
    }

}
