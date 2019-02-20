package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_clubs extends AppCompatActivity {


    EditText user,pass;
    Button login;
    TextView signup;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_clubs);

        user = (EditText)  findViewById(R.id.username_club);
        pass =(EditText) findViewById(R.id.password_club);
        signup = (TextView) findViewById(R.id.signup);
        login = (Button) findViewById(R.id.login_club);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = user.getText().toString();
                final String password =  pass.getText().toString();


                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }


                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                DatabaseReference ref1 =ref.child("Clubs");
                DatabaseReference ref2 =ref1.child(username);
                DatabaseReference ref3=ref2.child("password");


                ref3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        value=dataSnapshot.getValue(String.class);

                        if(value.equals(password)) {

                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(login_clubs.this,chapter_addevent.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Incorrect Input",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login_clubs.this,signup_club.class);
                startActivity(i);
            }

        });
    }
}
