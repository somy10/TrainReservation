package com.train.TrainReservation.Service;

import com.train.TrainReservation.Repository.TrainReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainReservationService {


     TrainReservationRepository trainReservationRepository;
      TrainReservationService(TrainReservationRepository repository)
      {
          this.trainReservationRepository=repository;
      }

    public Integer getAvailableSeats() {
          return Integer.valueOf( trainReservationRepository.getAvailableSeats());


    }

    public Integer bookSeat(String seatToBeBooked) {
          return Integer.valueOf( trainReservationRepository.setSeats(seatToBeBooked));
    }
}
