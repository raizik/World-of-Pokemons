package com.plainid.assignment.dao;

import javax.lang.model.type.NullType;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.ListIterator;

public class TrainersList {
    List<Trainer> trainers;
    public List<Trainer> getTrainers() {
        return trainers;
    }
    public Trainer findTrainer(String name) {
        for (Trainer element : this.trainers) {
            if (element.name == name)
                return element;
        }
        return null;
    }
    public void setTrainers(List<Trainer> trainers) { this.trainers = trainers;}
}