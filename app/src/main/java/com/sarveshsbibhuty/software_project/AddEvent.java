package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class AddEvent extends AppCompatActivity {


    EditText Eventname,organise,desc,ven,fees,t_seat,perk,date;
    Button addevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

    Eventname = (EditText) findViewById(R.id.name);
    organise = (EditText)findViewById(R.id.organiser);
    desc = (EditText)findViewById(R.id.des);
    ven = (EditText)findViewById(R.id.venue);
    fees = (EditText)findViewById(R.id.fee);
    t_seat = (EditText)findViewById(R.id.seats);
    perk = (EditText)findViewById(R.id.perks);
    date = (EditText)findViewById(R.id.Date);


    addevent = (Button)findViewById(R.id.add);

    addevent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final String name = Eventname.getText().toString();
            final String organiser = organise.getText().toString();
            final String des = desc.getText().toString();
            final String venue = ven.getText().toString();
            final String seats = t_seat.getText().toString();
            final String perks = perk.getText().toString();
            final String Date = date.getText().toString();

            if(TextUtils.isEmpty(name))
            {
                Toast.makeText(getApplicationContext(),"Enter Event Name",Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(organiser))
            {
                Toast.makeText(getApplicationContext(),"Enter Organiser Name",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(des))
            {
                Toast.makeText(getApplicationContext(),"Enter Description",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(venue))
            {
                Toast.makeText(getApplicationContext(),"Enter Venue",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(seats))
            {
                Toast.makeText(getApplicationContext(),"Enter total no. of seats",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(perks))
            {
                Toast.makeText(getApplicationContext(),"Enter Perks",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(Date))
            {
                Toast.makeText(getApplicationContext(),"Enter Date and Time",Toast.LENGTH_SHORT).show();
                return;
            }


            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            final DatabaseReference ref1 =ref.child("Events").child(name);

            ref1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                   //  Toast.makeText(getApplicationContext(),"Event Exists",Toast.LENGTH_SHORT).show();

                    }

                    else
                    {
                        ref1.child("Name").setValue(name);
                        ref1.child("Organiser").setValue(organiser);
                        ref1.child("Desc").setValue(des);
                        ref1.child("Venue").setValue(venue);
                        ref1.child("Seats").setValue(seats);
                        ref1.child("Perks").setValue(perks);
                        ref1.child("Date").setValue(Date);

                        Toast.makeText(getApplicationContext(),"Event Added",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(AddEvent.this,Requirements.class);
                        i.putExtra("Event",name);
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
