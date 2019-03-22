package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class event_register extends AppCompatActivity {

    Button hack,dev,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register);


        hack = (Button) findViewById(R.id.hack);
        dev = (Button) findViewById(R.id.dev);
        c = (Button) findViewById(R.id.c);

        hack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(event_register.this,hackgrid_reg.class);
                startActivity(i);
            }
        });


        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(event_register.this,devsoc_reg.class);
                startActivity(i);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(event_register.this,c2c_reg.class);
                startActivity(i);
            }
        });
    }
}
