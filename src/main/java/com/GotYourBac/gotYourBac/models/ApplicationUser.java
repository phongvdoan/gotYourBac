package com.GotYourBac.gotYourBac.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany(mappedBy = "appUser")
    public List<Drink> drinkList;

    String username;
    String password;
    String firstName;
    String lastName;
    String gender;
    double height;
    float weight;
    String profilepic;

    public ApplicationUser() {
    }

    public ApplicationUser(String username, String password, String firstName, String lastName, String gender, double height, float weight, String profilepic) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.profilepic = profilepic;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getProfilepic() {
        return profilepic;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public float calculateBAC() {
        float BAC;
        int numOfDrinks = 0;
        float genderConstant;
        float alcoholContent = 0.0f;

        for(Drink drink : this.drinkList){
           alcoholContent += (drink.getStrABV() / 100) * drink.drinkSize;
            numOfDrinks++;
        }

        if(this.gender.equals("M")) {
            genderConstant = 0.73f;

        } else if(this.gender.equals("F")) {
            genderConstant = 0.66f;
        } else {
            genderConstant = 0.73f;
        }

        BAC = numOfDrinks / alcoholContent / this.weight / genderConstant;
        //get the drink list by looping over the users drink
        return BAC;
    }
//
//    BAC =
//            (numDrinks / 0.3243 / weight / genderConstant)
//    MALE_CONST = 0.73;
//    FEMALE_CONST = 0.66;s
}
