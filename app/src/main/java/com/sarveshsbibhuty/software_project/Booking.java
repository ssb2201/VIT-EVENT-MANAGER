package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Booking extends AppCompatActivity {

    Button next;
    EditText full ;
    EditText block;
    EditText email;

    @Override
    public void onBackPressed() {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        next = (Button) findViewById(R.id.pay);
        full = (EditText) findViewById(R.id.full);
        block = (EditText) findViewById(R.id.block);
        email = (EditText) findViewById(R.id.email);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fu = full.getText().toString();
                String bl = block.getText().toString();
                String em = email.getText().toString();

                if (TextUtils.isEmpty(fu)) {
                    Toast.makeText(getApplicationContext(), "Enter Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(bl)) {
                    Toast.makeText(getApplicationContext(), "Enter Block and Room Number ", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(em)) {
                    Toast.makeText(getApplicationContext(), "Enter Email ", Toast.LENGTH_SHORT).show();
                    return;
                }








                Intent i = new Intent(Booking.this,acknowledge.class);
                startActivity(i);

            }
        });
    }
}
