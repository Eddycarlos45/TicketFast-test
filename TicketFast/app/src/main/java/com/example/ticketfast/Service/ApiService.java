package com.example.ticketfast.Service;

import com.example.ticketfast.Model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {

    @GET("/events")
    Call<List<Event>> listEvents();

    public static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://private-edc1c-ticketfast.apiary-mock.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

}
