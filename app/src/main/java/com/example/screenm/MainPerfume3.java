package com.example.screenm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainPerfume3 extends MainActivity2perfume {

    Button button0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfume3);
        button0=findViewById(R.id.button0);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPerfume3.this,MainActivity2perfume.class);
                startActivity(intent);
            }
        });
    }
}