package com.train.TrainReservation.controller;

import com.train.TrainReservation.Beans.Train;
import com.train.TrainReservation.Service.TrainReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TrainReservationController {
    TrainReservationService trainReservationService;

    TrainReservationController(TrainReservationService service) {
        this.trainReservationService = service;
    }

    @GetMapping("/getAvailableSeats")
    public Integer getAvailableSeats() {
        return trainReservationService.getAvailableSeats();

        //  return 9;
    }

    @PostMapping("/bookSeat")
    public Integer bookSeat(@RequestBody int seatsToBeBooked) {

        int availableSeats = getAvailableSeats();
        return Math.max(availableSeats - seatsToBeBooked, 0);
    }

    //   public Map<String, Integer> getAvailableSeatsByCoach() {
    //   Map<String,Integer> train =new HashMap<>();
//        train.put("A1", 50);
//        train.put("B1" , 30);
//        train.put("C1", 0);
//        return train;
// }
    @GetMapping("/getSeats")
    public Train getAvailableSeatsByCoach() {
        Train train = new Train();
        Map<String, Integer> trainCoach = new HashMap<String, Integer>();
        trainCoach.put("A1", 10);
        trainCoach.put("A2", 5);
        trainCoach.put("A3", 0);
        train.setCoach(trainCoach);
        return train;
    }

    @PostMapping("/AvailableSeatBookByCoach")
    public Train bookSeatByCoach(int seatsToBook) {

        Train train = getAvailableSeatsByCoach();
        StringBuilder result = new StringBuilder();
        Map<String, Integer> coachMap = train.getCoach();

        int remainingSeatsToBook;
        for (Map.Entry<String, Integer> coach : train.getCoach().entrySet()) {

            String trainCoach = coach.getKey();
            int availableSeats = coach.getValue();


            remainingSeatsToBook = availableSeats - seatsToBook;
                if(remainingSeatsToBook <= 0)
                {
                    seatsToBook=seatsToBook-availableSeats;
                    coachMap.put(trainCoach,0);
                    continue;
                }
                else
                {
                    coachMap.put(trainCoach, remainingSeatsToBook);
                    seatsToBook=seatsToBook-remainingSeatsToBook;

                }
            result.append("Booking sucessfully for ").append("seatsToBook:").append("\n");
            }
        train.setCoach(coachMap);

            return train;
        }
    }

