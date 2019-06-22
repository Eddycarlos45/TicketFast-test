package com.example.ticketfast.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ticketfast.R;

public class EventDesc extends AppCompatActivity {

    private ImageView image;
    private TextView textName, textCategory, textLocal, textDate,textPrice;
    private Button btn_buy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_desc);

        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        image = findViewById(R.id.image_View);
        textName = findViewById(R.id.text_name);
        textDate = findViewById(R.id.text_date);
        textLocal = findViewById(R.id.text_local);
        textCategory = findViewById(R.id.text_category);
        btn_buy = findViewById(R.id.btn_buy);
        textPrice = findViewById(R.id.text_price);

        if (getIntent() != null) {

            Glide.with(this).load(getIntent().getStringExtra("image")).into(image);
            textName.setText("Titulo: " + getIntent().getStringExtra("name"));
            textDate.setText("Data: " + getIntent().getStringExtra("date"));
            textLocal.setText("Local: " + getIntent().getStringExtra("local"));
            textCategory.setText("Categoria: " + getIntent().getStringExtra("category"));
            textPrice.setText("Valor: R$:" +getIntent().getStringExtra("price"));

        }
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventDesc.this,PayActivity.class);

                intent.putExtra("price",textPrice.getText());
                intent.putExtra("titulo",textName.getText());
                intent.putExtra("local",textLocal.getText());
                intent.putExtra("date",textDate.getText());
                startActivity(intent);
            }
        });
    }

}