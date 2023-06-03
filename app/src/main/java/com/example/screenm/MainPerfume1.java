package com.example.screenm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.screenm.MainActivity2perfume;
import com.example.screenm.R;

public class MainPerfume1 extends MainActivity2perfume {

    Button button11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfume1);
        button11=findViewById(R.id.button11);


        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPerfume1.this,MainActivity2perfume.class);
                startActivity(intent);
            }
        });
    }
}