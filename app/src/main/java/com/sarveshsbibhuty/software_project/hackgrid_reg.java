package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class hackgrid_reg extends AppCompatActivity {

    Button reg;
    String event;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackgrid_reg);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        event = pref.getString("reg","a");




        reg = (Button) findViewById(R.id.register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference myRef = database.getReference("Students").child(event);
                myRef.child("event").child("0").setValue("Hackgrid");
                Intent i = new Intent(hackgrid_reg.this,Booking.class);
                startActivity(i);
            }
        });
    }
}
