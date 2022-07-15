package com.sofka;

import static com.sofka.info.Register.defaultUsers;
import static com.sofka.info.Register.users;
import static com.sofka.ui.Menu.printMenu;
import static com.sofka.ui.ReturnBicycleMenu.returnBicycle;
import static com.sofka.util.Util.*;


public class BiciU {
    public static void main(String[] args){
        System.out.println(readTicket());

        //openText();
        //defaultUsers();
       // System.out.println(users);
       // printMenu();
        returnBicycle();

    }
}
