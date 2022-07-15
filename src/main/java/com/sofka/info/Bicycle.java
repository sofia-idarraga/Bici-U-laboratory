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

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "Code: " + uid + '\n' +
                "Type: " + type + '\n' +
                "Color: " + color + '\n';
    }
}
