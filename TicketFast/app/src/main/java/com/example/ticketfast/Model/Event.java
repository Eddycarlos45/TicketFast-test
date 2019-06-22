package com.example.ticketfast.Model;

public class Event {


    private  String image;
    private  String name;
    private  String date;
    private  String local;
    private String category;
    private String price;

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

    public String getCategoria() {
        return category;
    }

    public void setCategoria(String categoria) {
        this.category = categoria;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Event(){

    }

    public Event(String image, String name, String date, String local, String categoria,String price) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.local = local;
        this.category = categoria;
        this.price = price;
    }
}
