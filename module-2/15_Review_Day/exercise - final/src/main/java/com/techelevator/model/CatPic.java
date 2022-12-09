package com.techelevator.model;

public class CatPic {

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "CatPic{" +
                "file='" + file + '\'' +
                '}';
    }
}
