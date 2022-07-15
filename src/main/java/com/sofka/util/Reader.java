package com.sofka.util;

import java.util.Scanner;

public class Reader {
    public static String scannerText(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int scannerInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
