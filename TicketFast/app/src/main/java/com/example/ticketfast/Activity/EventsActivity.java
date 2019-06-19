package com.example.ticketfast.Activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ticketfast.Adapter.AdapterEvents;
import com.example.ticketfast.Model.Event;
import com.example.ticketfast.Service.ApiService;
import com.example.ticketfast.R;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class EventsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<Event> listaEventos = new ArrayList<>();
    private  Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        
        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        recyclerView = findViewById(R.id.recyclerMensagens);


        //Congigurar Adapter
        listar();
        AdapterEvents adapterMensagens = new AdapterEvents(listaEventos);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterMensagens);

    }
    public void listar() {
        Call<List<Event>> call = new RetrofitConfig().getApiService().listEvents();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                listaEventos = response.body();
                for(Event event : listaEventos){
                    listaEventos.add(event);
                }

                Log.d("---------","DEU CERTO");
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Log.d("---------",t.toString());
            }
        });

    }

}