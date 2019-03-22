package com.sarveshsbibhuty.software_project;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

public class delete extends AppCompatActivity {
    EditText eventname;
    Button delete;
   String event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        eventname = (EditText) findViewById(R.id.event_name);
        delete = (Button) findViewById(R.id.delete_event);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        event = pref.getString("reg","a");



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

                if(event.equals("Hackgrid"))
                {

                    final DatabaseReference ref1 = ref.child("Students").child(event);

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                ref1.child("event").child("0").setValue(" ");
                                Toast.makeText(getApplicationContext(), "Event Deleted ", Toast.LENGTH_SHORT).show();
                            } else {
                                // Toast.makeText(getApplicationContext(),"Event doesn't Exists ",Toast.LENGTH_SHORT).show();
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else if(event.equals("Devsoc"))
                {
                    final DatabaseReference ref1 = ref.child("students").child(event).child("event2");

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                ref1.removeValue();
                                Toast.makeText(getApplicationContext(), "Event Deleted ", Toast.LENGTH_SHORT).show();
                            } else {
                                 Toast.makeText(getApplicationContext(),"Event doesn't Exists ",Toast.LENGTH_SHORT).show();
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {


                        }
                    });

                }

                else if(event.equals("C2C"))
                {
                    final DatabaseReference ref1 = ref.child("students").child(event).child("event3");

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                ref1.removeValue();
                                Toast.makeText(getApplicationContext(), "Event Deleted ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(),"Event doesn't Exists ",Toast.LENGTH_SHORT).show();
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {


                        }
                    });
                }
            }
        });

    }
}
