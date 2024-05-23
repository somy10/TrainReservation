package com.train.TrainReservation.Service;

import com.train.TrainReservation.Repository.TrainReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TrainReservationServiceTest {

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @InjectMocks
    public  TrainReservationService trainReservationService ;
    @Mock
    TrainReservationRepository repository;
    @Test
    void testIfAvailableSeatsNotEmpty()
    {
        Mockito.when(repository.getAvailableSeats()).thenReturn("123");
    Integer seats   = trainReservationService.getAvailableSeats();
    assertNotNull(seats);
    }


    @Test
    void testIfSeatGettingBook()
    {
        Mockito.when(repository.setSeats("2")).thenReturn("198");
        Mockito.when(repository.getAvailableSeats()).thenReturn("200");
        int seatToBeBooked = 2;
        Integer seats= trainReservationService .getAvailableSeats();
        Integer booked= trainReservationService.bookSeat(String.valueOf(seatToBeBooked));
        assertEquals((int) booked,seats-seatToBeBooked);
    }
    @Test
    void testAvailableSeatsIfNotNegative()
    {

    }
}
