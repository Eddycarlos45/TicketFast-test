package com.example.ticketfast.Activity;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ticketfast.Adapter.AdapterEvents;
import com.example.ticketfast.Adapter.AdapterTicket;
import com.example.ticketfast.Model.Event;
import com.example.ticketfast.Model.Ticket;
import com.example.ticketfast.R;

import java.util.ArrayList;
import java.util.List;

public class TicketActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<Ticket> listTicket = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        recyclerView = findViewById(R.id.recyclerTicket);

        //Congigurar Adapter
        listaTicket();
        AdapterTicket adapter = new AdapterTicket(listTicket);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void listaTicket() {
        SQLiteDatabase myDB = openOrCreateDatabase("ingressos.db", MODE_PRIVATE, null);

        Cursor myCursor = myDB.rawQuery("select * from ingressos", null);

        for (myCursor.moveToLast(); !myCursor.isBeforeFirst(); myCursor.moveToPrevious()) {
            Integer id_db = myCursor.getInt(0);
            String name_db = myCursor.getString(1);
            String date_db = myCursor.getString(2);
            String local_db =  myCursor.getString(3);


            Ticket ticket = new Ticket(id_db, name_db, date_db, local_db);
            this.listTicket.add(ticket);

        }
        myCursor.close();
        myDB.close();

    }

}
