package com.sofka.info;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket implements IGenerateInfo {
    private String code;
    private Bicycle bicycle;
    private User user;
    private LocalDate date;
    private LocalTime entranceHour;
    private LocalTime endHour;
    private boolean helmet;
    private boolean noDamage;
    private int amount;
    private Status status;

    public Ticket(Bicycle bicycle, User user, LocalDate date, LocalTime entranceHour, int count) {
        this.code = generateCode(count, "T");
        this.bicycle = bicycle;
        this.user = user;
        this.date = date;
        this.entranceHour = entranceHour;
        this.helmet = true;
        this.noDamage = true;
        this.amount = 0;
    }

    public Ticket(String code, Bicycle bicycle, User user, LocalDate date, LocalTime entranceHour,
                   boolean helmet, boolean noDamage, int amount, Status status) {
        this.code = code;
        this.bicycle = bicycle;
        this.user = user;
        this.date = date;
        this.entranceHour = entranceHour;
        this.helmet = helmet;
        this.noDamage = noDamage;
        this.amount = amount;
        this.status = status;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }

    public void setNoDamage(boolean noDamage) {
        this.noDamage = noDamage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public LocalTime getEntranceHour() {
        return entranceHour;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String generateCode(int count, String type){
        count += 1;
        return (type+"-"+String.format("%03d",   count));
    }

    @Override
    public String toSaveTicket() {
        return  (code +"," + bicycle.toSaveTicket() +"," + user.toSaveTicket() + "," + date +"," + entranceHour +"," + endHour +
                "," + helmet +"," + noDamage +"," + amount +"," + status);
    }

    private String printEndHour(LocalTime endHour){
        if(this.endHour == null){
            return "-";
        }
        else {return this.endHour.format(DateTimeFormatter.ofPattern("HH:mm"));}
    }

    @Override
    public String toString() {
        return  "Code: " + code + '\n'+
                "Bicycle: " + bicycle.getUid() + '\n'+
                "User: " + user.getCode() + '\n'+
                "Name: " + user.getName() + '\n'+
                "Date: " + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + '\n'+
                "Start time: " + entranceHour.format(DateTimeFormatter.ofPattern("HH:mm")) + '\n'+
                "End time: " + printEndHour(endHour) + '\n'+
                "Have helmet: " + helmet + '\n'+
                "Good condition: " + noDamage + '\n'+
                "Amount: $" + amount + '\n'+
                "Status: " + status+ '\n';
    }
}
