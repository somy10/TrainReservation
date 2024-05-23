package com.train.TrainReservation.Repository.TrainReservation;

import com.train.TrainReservation.Repository.TrainReservationRepository;
import com.train.TrainReservation.controller.TrainReservationController;
import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
public class TrainReservationRespositoryTest{

    private List<String> list;
    @InjectMocks
    private TrainReservationRepository trainReservationRepository;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testIfAvailableSetSeats()
    {
     //   RestTemplate restTemplate=mock(RestTemplate.class);

        ResponseEntity<String> testResponse= ResponseEntity.created(null).body( "{\r\n\"status\":true\r\n}");
        Mockito.when(restTemplate.postForEntity(Mockito.any(String.class),Mockito.any(Object.class),Mockito.any(Class.class))).thenReturn(testResponse);
         String response=trainReservationRepository.setSeats("12334");
        assertNotNull(response);

    }
   @Test
    void testIfAvaiableSeats()
   {
      ResponseEntity <String> testResponse= ResponseEntity.created(null).body("200");

       Mockito.when(restTemplate.getForEntity(Mockito.any(String.class), Mockito.any(Class.class)))
               .thenReturn(new ResponseEntity<>(String.valueOf(testResponse), HttpStatus.OK));

       String response=trainReservationRepository.getAvailableSeats();
       Assertions.assertNotNull(testResponse.getBody(),response);
   }
}


