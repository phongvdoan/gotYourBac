package com.GotYourBac.gotYourBac.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Drink {

    //TODO: probably need some getters and setters depending on the app, but lets safely add each one we need throughout the process.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    ApplicationUser appUser;

    public String strIngredient;
    public float strABV;
    public int numOfDrinks;
    public float drinkSize;

    public Drink() {
    }

    public Drink(String strIngredient, float strABV, int numOfDrinks, float drinkSize) {
        this.strIngredient=strIngredient;
        this.strABV = strABV;
        this.numOfDrinks = numOfDrinks;
        this.drinkSize = drinkSize;
    }

    public String getStrIngredient() {
        return strIngredient;
    }

    public float getStrABV() {
        return strABV;
    }

    public int getNumOfDrinks() {
        return numOfDrinks;
    }

    public float getDrinkSize() {
        return drinkSize;
    }
}
