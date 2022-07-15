package com.sofka.util;

import com.sofka.info.Bicycle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

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
}
