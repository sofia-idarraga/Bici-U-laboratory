package com.sofka.info;


import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket implements GenerateInfo{
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
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String generateCode(int count, String type){
        count += 1;
        return (type+"-"+String.format("%03d",   count));
    }


    public String toSaveTicket() {
        return  (code +"," + bicycle +"," + user + "," + date +"," + entranceHour +"," + endHour +
                "," + helmet +"," + noDamage +"," + amount +"," + status);
    }
}
