package com.sofka.ui;

import com.sofka.info.Bicycle;
import com.sofka.info.Status;
import com.sofka.info.Ticket;
import com.sofka.info.User;

import java.time.LocalTime;
import java.util.ArrayList;

import static com.sofka.info.Register.bicycles;
import static com.sofka.info.Register.saveTicketChanges;
import static com.sofka.info.Register.users;
import static com.sofka.util.Reader.scannerInt;
import static com.sofka.util.Reader.scannerText;
import static com.sofka.util.Util.closeText;
import static com.sofka.util.Util.readTicket;

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
        saveTicketChanges(tickets);
        System.out.println("changes have been saved");

    }

    static int calculateAmount(boolean helmet, int damages, int time){
        int price = 5;
        int amount = 0;
        if(!helmet){
            amount += price;
        }
        if(damages > 0){
            amount += price*damages;
        }
        if(time>30){
           amount += Math.floor(time/30)*3;
        }
        return amount;
    }
    private static int calculateDifference(LocalTime entrance, LocalTime end){
        int entranceInMinutes = entrance.getHour()*60 + entrance.getMinute();
        int endInMinutes = end.getHour()*60 + end.getMinute();

        return endInMinutes-entranceInMinutes;
    }

    private static void setTicket(Ticket ticket){
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
        }else{
            ticket.setNoDamage(true);
        }
        ticket.setAmount(amount);
        if(amount !=0){
            updateUserStatus(ticket);
            updateBicycleStatus(ticket);
            System.out.println(ticket.getUser().getDebts());
            ticket.setStatus(Status.PENDING);
        }
        if (amount==0){
            ticket.setStatus(Status.OK);
        }
    }

    private static void updateBicycleStatus(Ticket ticket){
        for (Bicycle bicycle: bicycles) {
            if(bicycle.getUid().equals(ticket.getBicycle().getUid())){
                bicycle.setAvailable(true);
            }
        }
    }

    private static void updateUserStatus(Ticket ticket){

        for (User user: users) {
            if(user.getCode().equals(ticket.getUser().getCode())){
                user.setDebts(true);
            }
        }

    }
}
