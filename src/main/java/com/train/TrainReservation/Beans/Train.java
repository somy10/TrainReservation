package com.train.TrainReservation.Beans;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Train {
    Map<String,Integer> coach;

    public Map<String, Integer> getCoach() {
        return coach;
    }

    public void setCoach(Map<String, Integer> coach) {
        this.coach = coach;
    }
//    private List<String> coach;
//    private List<Integer> Seats;
//
//
}
