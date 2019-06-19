package com.example.ticketfast.Activity;

import com.example.ticketfast.Service.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

        public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()

                .baseUrl("http://private-edc1c-ticketfast.apiary-mock.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ApiService getApiService (){
        return this.retrofit.create(ApiService.class);
    }

}
