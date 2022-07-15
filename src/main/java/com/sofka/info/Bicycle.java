package com.sofka.info;

public class Bicycle {

    private String uid;
    private String type;
    private String color;
    private boolean available;

    public Bicycle(String uid, String type, String color, boolean available) {
        this.uid = uid;
        this.type = type;
        this.color = color;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "uid='" + uid + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", available=" + available +
                '}';
    }
}
