package com.train.TrainReservation.controller;

import com.train.TrainReservation.Beans.Train;
import com.train.TrainReservation.Service.TrainReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TrainReservationControllerTest {
    @InjectMocks
    TrainReservationController trainReservationController;

    @Mock
    TrainReservationService Service;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testIfAvailableSeatsNotEmpty() {

        Integer seats =  trainReservationController.getAvailableSeats();
        assertNotNull(seats);
    }

    @Test
    void testIfAvailableSeatsNotNegative()
    {
        Integer seats=  trainReservationController.getAvailableSeats();
        assertTrue(seats >=0);

    }

    @Test
    void testIfSeatGetteingBook()
    {
        int seatsToBeBooked = 2;
        Integer seats= trainReservationController.getAvailableSeats();
        Integer booked= trainReservationController.bookSeat(seatsToBeBooked);
        assertEquals((int) booked, seats - seatsToBeBooked);

    }
    @Test
    void testIfSeatGetteingGreaterthanZero()
    {
        int seatToBeBooked=10;
       trainReservationController.getAvailableSeats();
        Integer booked=trainReservationController.bookSeat(seatToBeBooked);
        assertTrue(booked >=0);
    }
    @Test
    void TestIfSeatGetAvailableSeatByCouch() {
        Train availableSeatsByCoach = trainReservationController.getAvailableSeatsByCoach();

        Map<String, Integer> train = new HashMap<>();
        train.put("A1", 100);
        train.put("B1", 50);
        train.put("C1", 0);
        availableSeatsByCoach.setCoach(train);

        assertEquals(availableSeatsByCoach.getCoach(), train);

    }
        @Test
     void TestIfSeatBookByCoach()
        {
            int seatsToBook=20;
            int seatsBooked=0;
            Train goaExpress =trainReservationController.getAvailableSeatsByCoach();
           Train booked=trainReservationController.bookSeatByCoach(seatsToBook);

        }
}
