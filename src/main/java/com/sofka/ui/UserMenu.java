package com.sofka.ui;

import com.sofka.info.User;

import static com.sofka.info.Register.users;
import static com.sofka.util.Reader.scannerInt;
import static com.sofka.util.Reader.scannerText;

public class UserMenu {

    static void createUser(){
        System.out.println("Enter your DNI: ");
        int dni = scannerInt();
        if (checkDni(dni)){
            System.out.println("User is already registered ");
            return;
        }
        System.out.println("Student or Proffesor? (S/T) ");
        String type = scannerText();
        while (!type.equalsIgnoreCase("S")  && !type.equalsIgnoreCase("T")){
            System.out.println("Invalid entrance, try again (S/T) ");
            type = scannerText();
        }
        System.out.println("Enter your complete name: ");
        String name = scannerText();
        System.out.println("Enter your age: ");
        int age = scannerInt();
        if(age<18){
            System.out.println("Invalid age, you must be an adult ");
            return;
        }
        User user = new User(type.toUpperCase(), dni, name, age);
        users.add(user);
        System.out.println("¡Register completed!");
        System.out.println(user);

    }

    static boolean checkDni(int dni){
        for (User user:users) {
            if(dni == user.getDni()){
                return true;
            }
        }
        return false;
    }
}
