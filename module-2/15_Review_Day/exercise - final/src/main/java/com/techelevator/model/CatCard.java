package com.techelevator.model;

import javax.validation.constraints.NotBlank;

public class CatCard {

    private int catCardId;
    @NotBlank(message = "url cannot be blank")
    private String imgUrl;
    @NotBlank(message = "cat fact cannot be blank")
    private String catFact;
    @NotBlank(message = "caption cannot be blank")
    private String caption;

    public int getCatCardId() {
        return catCardId;
    }

    public void setCatCardId(int catCardId) {
        this.catCardId = catCardId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCatFact() {
        return catFact;
    }

    public void setCatFact(String catFact) {
        this.catFact = catFact;
    }

    public String getCaption() {
        return caption;
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
