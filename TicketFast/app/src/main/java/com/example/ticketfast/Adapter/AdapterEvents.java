package com.example.ticketfast.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ticketfast.Model.Event;
import com.example.ticketfast.R;

import java.util.List;

import retrofit2.Retrofit;

public class AdapterEvents  extends RecyclerView.Adapter<AdapterEvents.MyViewHolder> {

    private List<Event> listaEventos;
    private Context context;



    public AdapterEvents(List<Event> lista, Context context) {
        this.listaEventos = lista;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Event evento = listaEventos.get(position);
        ImageView imageView = holder.image;
        Glide.with(context).load(listaEventos.get(position).getImage()).into(imageView);
        holder.desc.setText(evento.getName());

    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView desc;


        public MyViewHolder(View itemView) {

            super(itemView);

            image = itemView.findViewById(R.id.image_View);
            desc = itemView.findViewById(R.id.text_desc);
        }
    }
}
