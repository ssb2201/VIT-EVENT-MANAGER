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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signup_club extends AppCompatActivity {


    EditText clubname,school,username,pass;
    Button signupclubbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_club);

    clubname = (EditText)findViewById(R.id.club_name);
    school = (EditText) findViewById(R.id.school_name_club);
    username = (EditText) findViewById(R.id.user_club);
    pass = (EditText) findViewById(R.id.pass_club);
    signupclubbtn = (Button) findViewById(R.id.signup_club);


    signupclubbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final String club_name = clubname.getText().toString();
            final String school_name= school.getText().toString();
            final String user_name = username.getText().toString();
            final String pass_club = pass.getText().toString();


            if (TextUtils.isEmpty(club_name)) {
                Toast.makeText(getApplicationContext(), "Enter Club Name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(school_name)) {
                Toast.makeText(getApplicationContext(), "Enter School Name ", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(user_name)) {
                Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(pass_club)) {
                Toast.makeText(getApplicationContext(), "Enter Password ", Toast.LENGTH_SHORT).show();
                return;
            }


            FirebaseDatabase database = FirebaseDatabase.getInstance();


            final DatabaseReference myRef = database.getReference("Clubs").child(club_name);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){

                        Toast.makeText(getApplicationContext(), "Account Exists", Toast.LENGTH_SHORT).show();
                    }

                   else {

                        club Club = new club(club_name, school_name, user_name, pass_club);
                        myRef.setValue(Club);
                        Toast.makeText(getApplicationContext(), "Account successfully made.Please Login", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(signup_club.this, login_clubs.class);
                        startActivity(i);
                    }

                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {



                }
            });

        }
    });



    }
}
