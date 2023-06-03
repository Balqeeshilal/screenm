package com.example.screenm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mysingUp extends AppCompatActivity {

    private DatabaseReference dbref;
    long id_no=0;

    EditText username;
    EditText email;
    EditText password;
    EditText rpassword;
    EditText phon_number;
    Button buttonz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysing_up);

        buttonz=findViewById(R.id.buttonz);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        rpassword=findViewById(R.id.rpassword);
        phon_number=findViewById(R.id.phon_number);

        dbref= FirebaseDatabase.getInstance().getReference("Logins");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                    id_no=(snapshot.getChildrenCount());
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        buttonz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model_user m=new Model_user();
                m.setUsername(username.getText().toString().trim());
                m.setEmail(email.getText().toString().trim());
                m.setPassword(password.getText().toString().trim());
                m.setRpassword(rpassword.getText().toString().trim());
                m.setPhone_number(phon_number.getText().toString().trim());
                m.setIsactive("True");

                dbref.child(username.getText().toString().trim()).setValue(m);
                Intent intent=new Intent(mysingUp.this,Welcome.class);
                startActivity(intent);

            }
        });

    }
}