package com.example.cisionrestapi;

import com.example.cisionrestapi.domain.Payload;
import com.example.cisionrestapi.repository.PayloadRepository;
import com.example.cisionrestapi.service.PayloadServiceImpl;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CisionRestApiApplicationTests {

    @InjectMocks
    private PayloadServiceImpl getPayloadServiceImpl;
    private PayloadRepository payloadRepository;

    private final Payload payload1 = new Payload(1L,"ada","2018-10-09 00:12:12+0100",0);
    private final Payload payload2 = new Payload(2L,"noon", "2020-12-09 00:12:12+0100",0);
    private final List<Payload> payloadList = new ArrayList<>();


     @Before
     public void init() {
         MockitoAnnotations.initMocks(this);
         getPayloadServiceImpl = new PayloadServiceImpl(payloadRepository);
         payloadList.add(payload1);
         payloadList.add(payload2);
     }

     @Test
     public void longestPalSizeTest() throws Exception {
         assertEquals(3,getPayloadServiceImpl.longestPalSize(payload1.getContent()));
         assertEquals(4,getPayloadServiceImpl.longestPalSize(payload2.getContent()));
     }

     @Test
     public void savePayload(){
         when(getPayloadServiceImpl.save(payloadList)).thenReturn(payloadList);
         assertEquals(payloadList, payloadRepository.saveAll(payloadList));
     }

    @Test
    void contextLoads() {
    }

}
