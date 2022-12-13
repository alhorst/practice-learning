package com.techelevator.shelter.model;

import javax.validation.constraints.NotBlank;

public class Puppy {
    private int puppyId;
    @NotBlank(message = "Puppy name cannot be empty.")
    private String puppyName;
    @NotBlank(message = "Breed cannot be empty.")
    private String puppyBreed;
    @NotBlank(message = "Age cannot be empty.")
    private int puppyAge;
    @NotBlank(message = "Gender cannot be empty.")
    private String puppyGender;
    @NotBlank(message = "Shelter ID cannot be empty.")
    private int shelterId;

    public Puppy(int puppyId, String name, String breed, int age, String gender, int shelterId) {
        this.puppyId = puppyId;
        this.puppyName = name;
        this.puppyBreed = breed;
        this.puppyAge = age;
        this.puppyGender = gender;
        this.shelterId = shelterId;
    }

    public Puppy() {

    }

    public int getPuppyId() {
        return puppyId;
    }

    public String getPuppyName() {
        return puppyName;
    }

    public String getPuppyBreed() {
        return puppyBreed;
    }

    public int getPuppyAge() {
        return puppyAge;
    }

    public String getPuppyGender() {
        return puppyGender;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setPuppyId(int puppyId) {
        this.puppyId = puppyId;
    }

    public void setPuppyBreed(String puppyBreed) {
        this.puppyBreed = puppyBreed;
    }

    public void setPuppyName(String puppyName) {
        this.puppyName = puppyName;
    }

    public void setPuppyAge(int puppyAge) {
        this.puppyAge = puppyAge;
    }

    public void setPuppyGender(String puppyGender) {
        this.puppyGender = puppyGender;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    @Override
    public String toString() {
        return "Puppy{" +
                "puppyId=" + puppyId +
                ", name='" + puppyName + '\'' +
                ", breed='" + puppyBreed + '\'' +
                ", age=" + puppyAge +
                ", gender='" + puppyGender + '\'' +
                ", shelterId=" + shelterId +
                '}';
    }
}
