package com.example.screenm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Welcome extends AppCompatActivity {


    Button button4;
    Button button1;
    EditText username;
    EditText Password;

    private com.google.firebase.database.DatabaseReference dbref;//https://mobileapp-79ae2-default-rtdb.firebaseio.com/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        button4 = findViewById(R.id.button4);
        button1 = findViewById(R.id.button1);
        username = findViewById(R.id.username);
        Password = findViewById(R.id.Password);

        dbref = FirebaseDatabase.getInstance().getReference();


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int valid = 1;
                if (TextUtils.isEmpty(String.valueOf(username.getText()))) {
                    Toast.makeText(Welcome.this, "Enter Username", Toast.LENGTH_LONG).show();
                    valid = 0;
                } else if (TextUtils.isEmpty(String.valueOf(Password.getText()))) {
                    Toast.makeText(Welcome.this, "Enter Password", Toast.LENGTH_LONG).show();
                    valid = 0;
                }
                if (valid == 1) {
                    //Intent intent = new Intent(Login.this, Dashboard.class);
                    //startActivity(intent);
                    if (CheckUser_isvalid(String.valueOf(username.getText()), String.valueOf(Password.getText())) != "") {
                        //validate with firebase

                        dbref.child("Logins").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.hasChild(username.getText().toString().trim())) {

                                    //check password
                                    final String getPassword = snapshot.child(username.getText().toString().trim()).child("password").getValue(String.class);

                                    //Toast.makeText(Login.this, get, Toast.LENGTH_LONG).show();

                                    if (getPassword.equals(Password.getText().toString())) {
                                        //final String getIsActive=snapshot.child(txt_login_username.getText().toString().trim()).child("isactive").getValue(String.class);
                                        Toast.makeText(Welcome.this, "Successful login ", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(Welcome.this, MainActivity2perfume.class);
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(Welcome.this, "Invalid login", Toast.LENGTH_LONG).show();

                                    }


                                } else {
                                    Toast.makeText(Welcome.this, "Invalid login", Toast.LENGTH_LONG).show();

                                }
                            }



                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                        // Intent intent=new Intent(Login.this,Dashboard.class);
                        // startActivity(intent);

                    } else {
                        Toast.makeText(Welcome.this, "Wrong Credentials", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Welcome.this,mysingUp.class);
                startActivity(intent);
            }
        });


    }

    public String CheckUser_isvalid(String UserName, String Password) {
        final String[] val = {""};



        DatabaseReference conn = FirebaseDatabase.getInstance().getReference().child("logins");
        conn.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    if (snapshot1.getKey().equals("username")) {
                        String db_name = snapshot1.getValue().toString();


                        val[0] = "yes";
                        Toast.makeText(Welcome.this, db_name, Toast.LENGTH_LONG).show();


                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return "yes";
    }
}