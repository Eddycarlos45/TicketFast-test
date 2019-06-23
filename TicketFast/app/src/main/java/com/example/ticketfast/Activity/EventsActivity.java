package com.example.ticketfast.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.ticketfast.Adapter.AdapterEvents;
import com.example.ticketfast.Model.Event;
import com.example.ticketfast.Service.ApiService;
import com.example.ticketfast.R;
import com.example.ticketfast.Util.RecyclerItemClickListener;


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
    private Retrofit retrofit;

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;

    }

    //Menu Options
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ticket_menu: {

                Intent intent = new Intent(EventsActivity.this, TicketActivity.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        recyclerView = findViewById(R.id.recyclerEvent);


        //Congigurar Adapter
        listar();
        AdapterEvents adapter = new AdapterEvents(listaEventos, this);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        //Evento de Click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Intent intent = new Intent(EventsActivity.this, EventDesc.class);


                                intent.putExtra("name", listaEventos.get(position).getName());
                                intent.putExtra("category", listaEventos.get(position).getCategory());
                                intent.putExtra("local", listaEventos.get(position).getLocal());
                                intent.putExtra("image", listaEventos.get(position).getImage());
                                intent.putExtra("date", listaEventos.get(position).getDate());
                                intent.putExtra("price", listaEventos.get(position).getPrice());


                                startActivity(intent);


                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }


    public void listar() {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        final Call<List<Event>> call = apiService.listEvents();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                int code = response.code();
                if (code == 200) {
                    List<Event> lista = new ArrayList<>();
                    lista = response.body();

                    for (Event event : lista) {

                        Event e = new Event();
                        e.setName(event.getName());
                        e.setImage(event.getImage());
                        e.setPrice(event.getPrice());
                        e.setLocal(event.getLocal());
                        e.setDate(event.getDate());
                        e.setCategory(event.getCategory());
                        listaEventos.add(e);

                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Erro: " + String.valueOf(code), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Log.d("Error: ", t.getMessage());
            }
        });

    }
    

}