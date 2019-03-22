package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class chapter_addevent extends AppCompatActivity {


    Button add_event,modify_event,view_event,log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chapter_addevent);

        log = (Button) findViewById(R.id.logout);
        add_event = (Button) findViewById(R.id.add);
        modify_event = (Button) findViewById(R.id.modify);
        view_event = (Button) findViewById(R.id.view);

        add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(chapter_addevent.this,AddEvent.class);
                startActivity(i);

            }
        });
        modify_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(chapter_addevent.this,delete_event.class);
                startActivity(i);
            }
        });

        view_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(chapter_addevent.this,ViewEvent.class);
                startActivity(i);

            }
        });


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(chapter_addevent.this,MainActivity.class);
                startActivity(i);
            }
        });
    }




}
