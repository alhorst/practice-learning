package com.techelevator.model;

import javax.validation.constraints.NotBlank;

public class CatCard {

    private int catCardId;
    @NotBlank(message = "You must enter an image URL.")
    private String imgUrl;
    @NotBlank(message = "You must enter a cat fact.")
    private String catFact;
    @NotBlank(message = "You must enter a caption.")
    private String caption;

    public CatCard() {
    }

    public int getCatCardId() {
        return catCardId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getCatFact() {
        return catFact;
    }

    public String getCaption() {
        return caption;
    }

    public void setCatCardId(int catCardId) {
        this.catCardId = catCardId;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setCatFact(String catFact) {
        this.catFact = catFact;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "CatCard{" +
                "id=" + catCardId +
                ", imgUrl='" + imgUrl + '\'' +
                ", catFact='" + catFact + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }
}
