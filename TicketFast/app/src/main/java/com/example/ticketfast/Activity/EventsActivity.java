package com.example.ticketfast.Activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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
       ApiService apiService  = ApiService.retrofit.create(ApiService.class);
        final Call<List<Event>> call = apiService.listEvents();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                int code = response.code();
                if (code == 200) {
                    listaEventos = response.body();
                    for (Event event : listaEventos) {
                        listaEventos.add(event);
                    }
                    Log.d("xxxxxxxxxxxxxxxxxxxx", "Bom");
                }else{
                    Toast.makeText(getApplicationContext(),"Erro: " + String.valueOf(code),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
            Log.d("xxxxxxxxxxxxxxxxxxxx","Ruim");
            }
        });

    }

}