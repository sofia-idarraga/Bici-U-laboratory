package com.sofka.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static com.sofka.util.Util.readBicycle;
import static com.sofka.util.Util.writeTicket;

public class Register {

    static final String READING_FILE = "src/main/resources/bicycles.txt";

    public static ArrayList<Bicycle> bicycles =     readBicycle(READING_FILE);
    public static ArrayList<User> users = new ArrayList<>();

    static int count;

    public static void defaultUsers(){
        users.add(new User("P",11111,"David Jaramillo",25));
        users.add(new User("S",22222,"Ana Agudelo",19));
    }

    public static void generateTicket(Bicycle bicycle, User user){
        LocalDate date = LocalDate.now();
        LocalTime entranceHour= LocalTime.now();
        Ticket ticket =  new Ticket(bicycle,  user, date, entranceHour, count);
        ticket.setStatus(Status.ACTIVE);
        count +=1;
        writeTicket(ticket);
    }



}
