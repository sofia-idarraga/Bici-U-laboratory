package com.sofka.ui;

import com.sofka.info.Status;
import com.sofka.info.Ticket;

import java.time.LocalTime;
import java.util.ArrayList;

import static com.sofka.util.Reader.scannerInt;
import static com.sofka.util.Reader.scannerText;
import static com.sofka.util.Util.closeText;
import static com.sofka.util.Util.openText;
import static com.sofka.util.Util.readTicket;
import static com.sofka.util.Util.writeTicket;

public class ReturnBicycleMenu {

    public static void returnBicycle(){
        closeText();
        ArrayList<Ticket> tickets = readTicket();
        System.out.println("Enter ticket code: ");
        String code = scannerText();
        for (Ticket ticket: tickets) {
            if(code.equals(ticket.getCode())){
               setTicket(ticket);
                System.out.println("Ticket updated");
                System.out.println("\n"+ticket);
            }
        }
        saveChanges(tickets);
        System.out.println("changes have been saved");

    }

    static int calculateAmount(boolean helmet, int damages, int time){
        int price = 5;
        int amount = 0;
        if(helmet){
            amount += price;
        }
        if(damages > 0){
            amount += price*damages;
        }
        if(time>59){
           amount += Math.floor(time/30)*3;
        }
        return amount;
    }
    static int calculateDifference(LocalTime entrance, LocalTime end){
        int entranceInMinutes = entrance.getHour()*60 + entrance.getMinute();
        int endInMinutes = end.getHour()*60 + end.getMinute();

        return endInMinutes-entranceInMinutes;
    }

    static void setTicket(Ticket ticket){
        System.out.println("Has helmet: ");
        boolean helmet = Boolean.parseBoolean(scannerText());
        System.out.println("Quantity of damages: ");
        int damages = scannerInt();
        LocalTime endHour = LocalTime.now();
        LocalTime entranceHour = ticket.getEntranceHour();
        int difference= calculateDifference(entranceHour, endHour);
        int amount = calculateAmount(helmet,damages,difference);
        ticket.setEndHour(endHour);
        ticket.setHelmet(helmet);
        if (damages!=0){
            ticket.setNoDamage(false);
        }
        ticket.setAmount(amount);
        if(amount !=0){
            ticket.setStatus(Status.PENDING);
        }
        if (amount==0){
            ticket.setStatus(Status.OK);
        }
    }

    public static void saveChanges(ArrayList<Ticket> tickets){
        openText();
        for (Ticket ticket: tickets) {
            writeTicket(ticket);
        }
        // ESTO HAY QUE QUITARLO
        closeText();
    }
}
