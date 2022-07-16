package com.sofka.ui;

import com.sofka.info.Ticket;

import java.util.ArrayList;

import static com.sofka.ui.BorrowMenu.borrowBicycle;
import static com.sofka.ui.ReturnBicycleMenu.returnBicycle;
import static com.sofka.ui.UserMenu.createUser;
import static com.sofka.util.Reader.scannerInt;
import static com.sofka.util.Util.closeText;
import static com.sofka.util.Util.readTicket;

public class TicketHistoryMenu {

    public static void printMenu(){
        closeText();
        ArrayList<Ticket> tickets = readTicket();
        int option = scannerInt();

            System.out.println("_________________________");
            System.out.println(
                    """
                    
                    5.1. Show all tickets
                    5.2. Search by code                  
                    5.3. Search by status
                                       
                    """);

            cases(option);

    }

    private static void cases(int option) {
        switch (option) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("Invalid entrance");
        }
    }


}
