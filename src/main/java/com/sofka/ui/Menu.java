package com.sofka.ui;

import static com.sofka.ui.BorrowMenu.borrowBicycle;
import static com.sofka.ui.PayTicketMenu.payTicket;
import static com.sofka.ui.ReturnBicycleMenu.returnBicycle;
import static com.sofka.ui.TicketHistoryMenu.printTicketMenu;
import static com.sofka.ui.UserMenu.createUser;
import static com.sofka.util.Reader.scannerInt;

public class Menu {

    public static void printMenu(){
        int option = 0;

        do{
            System.out.println("_________________________");
            System.out.println(
                    """
                    
                    Bici - U
                    
                    1. Register user
                    2. Borrow Bicycle                   
                    3. Return Bicycle
                    4. Pay tickets
                    5. Tickets history
                    6. Exit
                    
                    """);
            option = scannerInt();
            cases(option);

        }while(option != 6);
    }

    private static void cases(int option){
        switch (option){
            case 1:
                createUser();
                break;
            case 2:
                borrowBicycle();
                break;
            case 3:
                returnBicycle();
                break;
            case 4:
                payTicket();
                break;
            case 5:
                printTicketMenu();
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid entrance, try again");

        }
    }
}
