package com.techelevator.shelter.model;

import javax.validation.constraints.NotBlank;

public class Shelter {

    private int shelterId;
    @NotBlank(message = "Shelter name cannot be empty.")
    private String name;
    @NotBlank(message = "Address cannot be empty.")
    private String address;
    @NotBlank(message = "City cannot be empty.")
    private String city;
    @NotBlank(message = "State cannot be empty.")
    private String state;
    @NotBlank(message = "ZIP cannot be empty.")
    private String zip;

    public Shelter() {

    }

    public Shelter(int shelterId, String name, String address, String city, String state, String zip) {
        this.shelterId = shelterId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getShelterId() {
        return shelterId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Shelter{" +
                "shelterId=" + shelterId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
