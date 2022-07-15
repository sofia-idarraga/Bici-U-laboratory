package com.sofka.util;

import com.sofka.info.Bicycle;
import com.sofka.info.Ticket;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    static File file = null;
    static FileWriter fileWriter = null;
    public static BufferedWriter bufferedWriter;

    static final String WRITING_FILE = "src/main/resources/tickets.txt";
    public static ArrayList<Bicycle> readBicycle(String externalFile){
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Bicycle> bicycles = new ArrayList<>();

        try {

            file = new File(externalFile);
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

    public static void openText(){
        try {
            file = new File(WRITING_FILE);
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
