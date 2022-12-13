package com.techelevator.shelter.model;

import javax.validation.constraints.NotBlank;

public class Shelter {
    private int shelterId;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Address cannot be empty")
    private String address;
    @NotBlank(message = "City cannot be empty")
    private String city;
    @NotBlank(message = "State cannot be empty")
    private String state;
    @NotBlank(message = "Zip cannot be empty")
    private String zip;

    public Shelter() { // if we create a constructor like the one below, let's make spring happy
        // and also include a default constructor
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

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
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
