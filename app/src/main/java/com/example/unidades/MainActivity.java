package com.example.unidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

   ImageButton Tempbutton,Longbutton,Pesobutton,Volumenbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Tempbutton =(ImageButton) findViewById(R.id.tempButton);

        Tempbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Temperatura.class);
                startActivity(intent);
            }
        });
        Longbutton =(ImageButton) findViewById(R.id.longButton);
        Longbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Longitud.class);
                startActivity(intent);
            }
        });

        Pesobutton =(ImageButton) findViewById(R.id.pesoButton);
        Pesobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Peso.class);
                startActivity(intent);
            }
        });
        Volumenbutton =(ImageButton) findViewById(R.id.volumenButton);
        Volumenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Volumen.class);
                startActivity(intent);
            }
        });
    }
}