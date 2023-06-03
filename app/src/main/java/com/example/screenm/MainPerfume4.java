package com.example.screenm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainPerfume4 extends MainActivity2perfume {

    Button button12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfume4);
        button12=findViewById(R.id.button12);


        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPerfume4.this,MainActivity2perfume.class);
                startActivity(intent);
            }
        });
    }
}