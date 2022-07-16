package com.sofka.ui;

import com.sofka.info.Status;
import com.sofka.info.Ticket;

import java.util.ArrayList;

import static com.sofka.info.Register.saveTicketChanges;
import static com.sofka.util.Reader.scannerInt;
import static com.sofka.util.Reader.scannerText;
import static com.sofka.util.Util.closeText;
import static com.sofka.util.Util.readTicket;

public class TicketHistoryMenu {

    public static void printTicketMenu(){
        closeText();
        ArrayList<Ticket> tickets = readTicket();
        saveTicketChanges(tickets);

        System.out.println("_________________________");
        System.out.println(
                """
                
                5.1. Show all tickets
                5.2. Search by code                  
                5.3. Search by status
                                   
                """);
        int option = scannerInt();
        cases(option, tickets);

    }

    private static void cases(int option, ArrayList<Ticket> tickets) {
        switch (option) {
            case 1:
                printAll(tickets);
                break;
            case 2:
                printByCode(tickets);
                break;
            case 3:
                printByStatus(tickets);
                break;
            default:
                System.out.println("Invalid entrance");
        }
    }

    private static void printAll(ArrayList<Ticket> tickets){
        System.out.println("-------------------------------------------------------------");
        System.out.format("%-10s %-20s %-20s %-20s %-20s", "Code ", "| User ID ", "| Name ", "| Amount ($) ", "| Status");
        System.out.println();
        for (Ticket ticket: tickets) {
            printEachTicket(ticket);
        }

    }

    private static void printByCode(ArrayList<Ticket> tickets){
        System.out.println("Entrance the ticket code: ");
        String code = scannerText();
        System.out.println("-------------------------------------------------------------");
        System.out.format("%-10s %-20s %-20s %-20s %-20s", "Code ", "| User ID ", "| Name ", "| Amount ($) ", "| Status");
        System.out.println();
        for (Ticket ticket: tickets) {
            if(code.equals(ticket.getCode())){
                printEachTicket(ticket);
            }
        }
    }

    private static void printByStatus(ArrayList<Ticket> tickets){
        System.out.println("Entrance the ticket status: ");
        String status = scannerText();
        System.out.println("-------------------------------------------------------------");
        System.out.format("%-10s %-20s %-20s %-20s %-20s", "Code ", "| User ID ", "| Name ", "| Amount ($) ", "| Status");
        System.out.println();
        for (Ticket ticket: tickets) {
            if(Status.valueOf(status.toUpperCase()).equals(ticket.getStatus())){
                printEachTicket(ticket);
            }
        }
    }

    private static void printEachTicket(Ticket ticket){
        System.out.format("%-10s %-20s %-20s %-20s %-20s","  " +ticket.getCode(),"  " +ticket.getUser().getCode(),
                "  " +ticket.getUser().getName(),"  " +ticket.getAmount(),"  " + ticket.getStatus());
        System.out.println();
    }

}
