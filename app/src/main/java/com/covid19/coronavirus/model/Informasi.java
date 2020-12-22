package com.covid19.coronavirus.model;

public class Informasi {

    private String title;
    private int image, imgDropdown;

    public Informasi(String title, int image, int imgDropdown) {
        this.title = title;
        this.image = image;
        this.imgDropdown = imgDropdown;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImgDropdown() {
        return imgDropdown;
    }

    public void setImgDropdown(int imgDropdown) {
        this.imgDropdown = imgDropdown;
    }
}