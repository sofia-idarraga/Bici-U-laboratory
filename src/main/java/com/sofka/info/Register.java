package com.sofka.info;

import java.util.ArrayList;

import static com.sofka.util.Util.readBicycle;

public class Register {

    static final String EXTERNAL_FILE = "src/main/resources/bicycles.txt";
    public static ArrayList<Bicycle> bicycles =     readBicycle(EXTERNAL_FILE);
    public static ArrayList<User> users = new ArrayList<>();

    public static void defaultUsers(){

        users.add(new User("P",11111,"David Jaramillo",25));
        users.add(new User("S",22222,"Ana Agudelo",19));
    }









}
