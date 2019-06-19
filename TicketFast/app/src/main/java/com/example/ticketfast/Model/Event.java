package com.example.ticketfast.Model;

public class Event {

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

    private  String image;
    private  String name;


    public Event(){

    }

    public Event(String Image, String name){
        this.image = Image;
        this.name = name;


    }
}
