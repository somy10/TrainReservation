package com.train.TrainReservation.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class TrainReservationRepository {

     RestTemplate restTemplate;


    TrainReservationRepository(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;

    }

    public String getAvailableSeats() {
        HttpHeaders headers = new HttpHeaders();
        //  headers.set("seats", "200");
        //  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String resourceURL = "https://02587953-4497-406e-b981-047741e06dd5.mock.pstmn.io/seats";
        ResponseEntity<String> response=restTemplate.getForEntity(resourceURL, String.class);

        return response.getBody();

    }

    public String setSeats(String number) {
        String resourceURL = "https://02587953-4497-406e-b981-047741e06dd5.mock.pstmn.io/setSeats";

        HttpEntity<Integer> request;
        request = new HttpEntity<>(Integer.valueOf(number));
        ResponseEntity<String> response = restTemplate.postForEntity(resourceURL, request, String.class);
        return response.getBody();
    }

}
