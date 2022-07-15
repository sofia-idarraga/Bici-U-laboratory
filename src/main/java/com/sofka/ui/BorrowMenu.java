package com.sofka.ui;

import com.sofka.info.Bicycle;
import com.sofka.info.User;

import static com.sofka.info.Register.*;
import static com.sofka.util.Reader.scannerText;
import static java.util.Objects.isNull;

public class BorrowMenu {

    static void borrowBicycle(){
        System.out.println("Enter ID: ");
        String id = scannerText();
        User user = foundUser(id);
        if(!checkUser(user)){
            return;
        }
        System.out.println("Choose a bicycle Mountain or Road? (M/R) ");
        String type = scannerText();
        while (!type.equalsIgnoreCase("M")  && !type.equalsIgnoreCase("R")){
            System.out.println("Invalid entrance, try again (M/R) ");
            type = scannerText();
        }
        Bicycle bicycle = foundBicycle(completeType(type));
        if (isNull(bicycle)){
            System.out.println("The is no "+completeType(type)+" bicycles available.");
            return;
        }
        System.out.println("Bicycle chosen! ");
        System.out.println(bicycle);
        bicycle.setAvailable(false);

    }

    static boolean checkUser(User user){
        if(isNull(user)){
            System.out.println("User is not registered");
            return false;
        }
        if (user.getDebts()){
            System.out.println("The user "+user.getCode()+" has a tickets with debt. Please cancel it" +
                    "and try again");
            return false;
        }
        return true;
    }

    static User foundUser(String id){
        User foundUser = null;
        for (User user: users) {
            if(id.equals(user.getCode())){
                foundUser = user;
            }
        }
        return foundUser;
    }

    static Bicycle foundBicycle(String type){
        Bicycle foundBicycle = null;
        for (Bicycle bicycle: bicycles){
            if (bicycle.getType().equals(type) && bicycle.isAvailable()){
                foundBicycle = bicycle;
            }
        }
        return foundBicycle;
    }

    static String completeType(String type){
        if (type.equalsIgnoreCase("M")){
            return "Mountain";
        }
        else {return  "Road";}
    }
}
