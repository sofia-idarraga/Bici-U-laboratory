package com.sofka.util;

import com.sofka.info.Bicycle;
import com.sofka.info.Status;
import com.sofka.info.Ticket;
import com.sofka.info.User;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Util {

    static File file = null;
    static FileWriter fileWriter = null;
    public static BufferedWriter bufferedWriter;

    static final String BICYCLES_FILE = "src/main/resources/bicycles.txt";

    static final String TICKETS_FILE = "src/main/resources/tickets.txt";
    public static ArrayList<Bicycle> readBicycle(){
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Bicycle> bicycles = new ArrayList<>();

        try {

            file = new File(BICYCLES_FILE );
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            List<String> newBicycle;

            while ((line = bufferedReader.readLine()) != null){
                newBicycle = Arrays.stream(line.split(";")).toList();
                bicycles.add(new Bicycle(newBicycle.get(0), newBicycle.get(1) , newBicycle.get(2) , Boolean.parseBoolean( newBicycle.get(3)) ));
            }

            bufferedReader.close();
            fileReader.close();

        }catch (Exception exception){
            System.out.println("File reading has failed - " +  exception.getMessage());
        }

        return bicycles;
    }

    public static ArrayList<Ticket> readTicket(){
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Ticket> tickets = new ArrayList<>();

        try {

            file = new File(TICKETS_FILE );
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            List<String> newLine;

            while ((line = bufferedReader.readLine()) != null){
                newLine = Arrays.stream(line.split(",")).toList();
                Bicycle bicycle = new Bicycle(newLine.get(1),newLine.get(2),newLine.get(3),Boolean.parseBoolean(newLine.get(4)));
                User user =  new User(newLine.get(5), parseInt(newLine.get(6)) ,newLine.get(7),parseInt(newLine.get(8)));
                Ticket ticket = new Ticket(newLine.get(0),bicycle,user,
                        LocalDate.parse(newLine.get(9)), LocalTime.parse(newLine.get(10)),Boolean.parseBoolean(newLine.get(12)),
                        Boolean.parseBoolean(newLine.get(13)), parseInt(newLine.get(14)), Status.valueOf(newLine.get(15))
                );
                tickets.add(ticket);
            }

            bufferedReader.close();
            fileReader.close();

        }catch (Exception exception){
            System.out.println("File reading has failed - " +  exception.getMessage());
        }

        return tickets;
    }

    public static void openText(){
        try {
            file = new File(TICKETS_FILE);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

        }catch (Exception exception){
            System.out.println("Something happened  - " +  exception.getMessage());
        }
    }

    public static void closeText(){
        try {
            bufferedWriter.close();
        }catch (Exception exception){
            System.out.println("Something happened - " +  exception.getMessage());

        }
    }

    public static void writeTicket(Ticket ticket){

        try {
            bufferedWriter.write(ticket.toSaveTicket()+"\n");
        }catch (Exception exception){
            System.out.println("File writing has failed - " +  exception.getMessage());
        }
    }
}
