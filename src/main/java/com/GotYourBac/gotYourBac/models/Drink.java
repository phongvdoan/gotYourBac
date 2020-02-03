package com.GotYourBac.gotYourBac.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String drinkName;
    float alcoholContent;
    int numOfDrinks;

    public Drink() {
    }

    public Drink(String drinkName, float alcoholContent, int numOfDrinks) {
        this.drinkName=drinkName;
        this.alcoholContent = alcoholContent;
        this.numOfDrinks = numOfDrinks;
    }
}
