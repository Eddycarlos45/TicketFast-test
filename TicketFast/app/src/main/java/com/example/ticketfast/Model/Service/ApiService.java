package com.example.ticketfast.Model.Service;

import com.example.ticketfast.Model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("/events")
    Call<List<Event>> listEvents();
}
