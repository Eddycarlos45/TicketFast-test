package com.example.ticketfast.Model;

public class Event {


    private  String image;
    private  String name;
    private  String date;
    private  String local;
    private String categoria;

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
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public Event(String image, String name, String date, String local, String categoria) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.local = local;
        this.categoria = categoria;
    }
}
