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

    private String strIngredient;
    private float strABV;
    private int numOfDrinks;
    private float drinkSize;

    public Drink() {
    }

    public Drink(String drinkName, float alcoholContent, int numOfDrinks, float drinkSize) {
        this.strIngredient = drinkName;
        this.strABV = alcoholContent;
        this.numOfDrinks = numOfDrinks;
        this.drinkSize = drinkSize;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "strIngredient='" + strIngredient + '\'' +
                ", strABV=" + strABV +
                ", numOfDrinks=" + numOfDrinks +
                '}';
    }

    public String getAlcoholName() {
        return strIngredient;
    }

    public float getAlcoholContent() {
        return strABV;
    }

    public int getNumOfDrinks() {
        return numOfDrinks;
    }

    public float getDrinkSize() {
        return drinkSize;
    }

}
