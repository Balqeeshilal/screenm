package com.example.screenm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainPerfume2 extends MainActivity2perfume {

    Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfume2);
        button6=findViewById(R.id.button6);


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPerfume2.this,MainActivity2perfume.class);
                startActivity(intent);
            }
        });
    }
}