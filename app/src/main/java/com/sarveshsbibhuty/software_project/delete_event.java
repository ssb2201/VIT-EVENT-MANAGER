package com.sarveshsbibhuty.software_project;

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

public class delete_event extends AppCompatActivity {

    EditText eventname;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_event);

        eventname = (EditText) findViewById(R.id.event_name);
        delete = (Button) findViewById(R.id.delete_event);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String event = eventname.getText().toString();

                if(TextUtils.isEmpty(event))
                {
                    Toast.makeText(getApplicationContext(),"Enter Event Name",Toast.LENGTH_SHORT).show();
                    return;
                }

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference ref1 =ref.child("Events").child(event);

                ref1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists())
                        {
                            ref1.removeValue();
                            Toast.makeText(getApplicationContext(),"Event Deleted ",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                          //  Toast.makeText(getApplicationContext(),"Event doesn't Exists ",Toast.LENGTH_SHORT).show();
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
