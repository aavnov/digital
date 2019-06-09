package com.example.licensecheck.Entity;

public class Request {

    public String name;
    public  String inn;
    public String ogrn;
    public String activity_type;
    public String address;
    public String date_register;
    public String date_termination;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_register() {
        return date_register;
    }

    public void setDate_register(String date_register) {
        this.date_register = date_register;
    }

    public String getDate_termination() {
        return date_termination;
    }

    public void setDate_termination(String date_termination) {
        this.date_termination = date_termination;
    }
}
