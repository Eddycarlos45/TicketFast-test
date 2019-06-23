package com.example.ticketfast.Model;

public class Event {


    private  String name;
    private  String image;
    private  String date;
    private  String local;
    private String category;
    private String price;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Event(){

    }

    public Event(String image, String name, String date, String local, String category,String price) {
        this.name = name;
        this.image = image;
        this.date = date;
        this.local = local;
        this.category = category;
        this.price = price;
    }
}
