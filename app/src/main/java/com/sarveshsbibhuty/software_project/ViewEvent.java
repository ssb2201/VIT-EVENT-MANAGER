package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewEvent extends AppCompatActivity {


    Button hack,dev,c;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);


     hack = (Button) findViewById(R.id.hack);
     dev = (Button) findViewById(R.id.dev);
     c = (Button) findViewById(R.id.c);



     hack.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(ViewEvent.this,hackgrid_view.class);
             startActivity(i);
         }
     });


     dev.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(ViewEvent.this,devsoc.class);
             startActivity(i);
         }
     });

     c.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(ViewEvent.this,c2c.class);
             startActivity(i);
         }
     });

    }
}
