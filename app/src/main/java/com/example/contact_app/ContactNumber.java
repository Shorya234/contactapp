package com.example.contact_app;

public class ContactNumber {
    String Name;
    String Number;

    public ContactNumber(String name, String number) {
        this.Name = name;
        this.Number = number;
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }
}
