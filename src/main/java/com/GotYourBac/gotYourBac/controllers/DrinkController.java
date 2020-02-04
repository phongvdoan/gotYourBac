package com.GotYourBac.gotYourBac.controllers;

import com.GotYourBac.gotYourBac.models.Drink;
import com.GotYourBac.gotYourBac.models.DrinkRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Controller
public class DrinkController {

    @Autowired
    DrinkRepository drinkRepository;

    @GetMapping("/addDrinks")
    public String goHome() {
        return "drinks";
    }
    @PostMapping("/addDrinks")
    public RedirectView addDrinks(String drinkName, int numberOfDrinks, float drinkSize) throws IOException {

        Gson gson = new Gson();

        URL url = new URL("https://www.thecocktaildb.com/api/json/v2/9973533/search.php?i=" + drinkName);
        System.out.println("url = " + url);
        HttpURLConnection apiConnection = (HttpURLConnection) url.openConnection();
        apiConnection.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));

        String drinkJSON = input.readLine();

        JsonObject incomingObject = gson.fromJson(drinkJSON, JsonObject.class);

        JsonArray incomingArr = incomingObject.get("ingredients").getAsJsonArray();

        Drink newDrink = gson.fromJson(incomingArr.get(0), Drink.class);

        Drink drink = new Drink(newDrink.getAlcoholName(), newDrink.getAlcoholContent(), numberOfDrinks, drinkSize);

        System.out.println("drink.getStrIngredient() = " + drink.getAlcoholName());
        System.out.println("drink.getStrIngredient() = " + drink.getAlcoholContent());
        System.out.println("drink.getStrIngredient() = " + drink.getNumOfDrinks());
        System.out.println("drink.getStrIngredient() = " + drink.getDrinkSize());

        drinkRepository.save(drink);

        return new RedirectView("/addDrinks");
    }
}
