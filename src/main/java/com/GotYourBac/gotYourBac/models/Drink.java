package com.GotYourBac.gotYourBac.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drink {

    //TODO: probably need some getters and setters depending on the app, but lets safely add each one we need throughout the process.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String drinkName;
    float alcoholContent;
    int numOfDrinks;
    float drinkSize;

    public Drink() {
    }

    public Drink(String drinkName, float alcoholContent, int numOfDrinks, float drinkSize) {
        this.drinkName=drinkName;
        this.alcoholContent = alcoholContent;
        this.numOfDrinks = numOfDrinks;
        this.drinkSize = drinkSize;
    }
}
