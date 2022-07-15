package com.sofka.ui;


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

    static void cases(int option){
        switch (option){
            case 1:
                createUser();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid entrance, try again");

        }
    }




}
