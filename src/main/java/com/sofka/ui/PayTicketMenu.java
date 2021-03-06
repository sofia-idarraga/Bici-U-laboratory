package com.sofka.ui;

import com.sofka.info.Status;
import com.sofka.info.Ticket;
import com.sofka.info.User;

import java.util.ArrayList;

import static com.sofka.info.Register.saveTicketChanges;
import static com.sofka.info.Register.users;
import static com.sofka.util.Reader.scannerText;
import static com.sofka.util.Util.closeText;
import static com.sofka.util.Util.readTicket;

public class PayTicketMenu  {

    public static void payTicket(){
        closeText();
        ArrayList<Ticket> tickets = readTicket();
        System.out.println("Enter ticket code: ");
        String code = scannerText();
        for (Ticket ticket: tickets) {
            if(code.equals(ticket.getCode())){
                setTicketAndUser(ticket);
                System.out.println("Ticket updated");
                System.out.println("\n"+ticket);
            }
        }
        saveTicketChanges(tickets);
        System.out.println("changes have been saved");
    }

    private static void setTicketAndUser(Ticket ticket) {
        ticket.setStatus(Status.OK);
        for (User user: users) {
            if(user.getCode().equals(ticket.getUser().getCode()) ){
                user.setDebts(false);
            }
        }
    }

}
