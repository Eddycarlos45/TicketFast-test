package com.example.ticketfast.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ticketfast.Model.Ticket;
import com.example.ticketfast.R;

import java.util.List;

public class AdapterTicket extends RecyclerView.Adapter<AdapterTicket.MyViewHolder> {

    private List<Ticket> listTicket;


    public AdapterTicket(List<Ticket> lista) {
        this.listTicket = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_ticket, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Ticket ticket = listTicket.get(position);
        holder.title.setText(ticket.getName());
        holder.date.setText(ticket.getDate());
        holder.local.setText(ticket.getLocal());

    }

    @Override
    public int getItemCount() {
        return listTicket.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        TextView local;


        public MyViewHolder(View itemView) {

            super(itemView);

            title = itemView.findViewById(R.id.text_title);
            date = itemView.findViewById(R.id.text_date);
            local = itemView.findViewById(R.id.text_local);

        }
    }
}
