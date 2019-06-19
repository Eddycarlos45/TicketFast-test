package com.example.ticketfast.Activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ticketfast.Adapter.AdapterEvents;
import com.example.ticketfast.Model.Event;
import com.example.ticketfast.Model.Service.ApiService;
import com.example.ticketfast.R;


import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class EventsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<Event> listaEventos = new ArrayList<>();
    private  Retrofit retrofit;
    private ApiService api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);



        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        recyclerView = findViewById(R.id.recyclerMensagens);


        //Congigurar Adapter
        listarEventos();
        AdapterEvents adapterMensagens = new AdapterEvents(listaEventos);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterMensagens);

    }

    public void listarEventos() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://private-edc1c-ticketfast.apiary-mock.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        api = retrofit.create(ApiService.class);
        api.listEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
            listaEventos = response.body();
                Log.d("=======",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Log.d("xxxxxxxxx",t.toString());
            }
        });
    }


}