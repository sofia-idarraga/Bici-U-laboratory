package com.sofka.info;

public class User implements GenerateInfo{
    private String type;
    private int dni;
    private String code;
    private String name;
    private int age;
    private boolean debts;

    public User(String type, int dni, String name, int age) {
        this.type = type;
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.debts = false;
        this.code = generateCode(dni,type);
    }

    public int getDni() {
        return dni;
    }

    public String getCode() {
        return code;
    }

    public boolean getDebts(){
        return debts;
    }

    @Override
    public String generateCode(int dni, String type) {
        return (type+"-"+String.format("%09d", dni));
    }

    @Override
    public String toString() {
        return  "ID: " + code + '\n' +
                "Name: " + name + '\n' +
                "Age: " + age ;
    }
    @Override
    public String toSaveTicket(){
        return type+","+dni+","+name+","+age;
    }

    public String getName() {
        return name;
    }
}
