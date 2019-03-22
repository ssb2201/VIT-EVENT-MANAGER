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

public class Requirements extends AppCompatActivity {

    EditText ref,fur,bud,other;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirements);

        ref = (EditText)findViewById(R.id.re);
        fur = (EditText) findViewById(R.id.fur);
        bud = (EditText) findViewById(R.id.bud);
        other = (EditText) findViewById(R.id.req);
        submit = (Button) findViewById(R.id.Sub);
        Intent intent = getIntent();
        final String result = intent.getStringExtra("Event");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String re = ref.getText().toString();
                final  String fu = fur.getText().toString();
                final String bu = bud.getText().toString();
                final String oth = other.getText().toString();




                if(TextUtils.isEmpty(re))
                {
                    Toast.makeText(getApplicationContext(),"Enter Refreshments",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(fu))
                {
                    Toast.makeText(getApplicationContext(),"Enter Furnitures",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(bu))
                {
                    Toast.makeText(getApplicationContext(),"Enter Budget",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(oth))
                {
                    Toast.makeText(getApplicationContext(),"Enter Other requirements",Toast.LENGTH_SHORT).show();
                    return;
                }


                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                final  DatabaseReference ref1 =ref.child("Events").child(result);

                ref1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        ref1.child("Refreshments").setValue(re);
                        ref1.child("Furniture").setValue(fu);
                        ref1.child("Budget").setValue(bu);
                        ref1.child("Others").setValue(oth);
                        Intent i = new Intent(Requirements.this,chapter_addevent.class);
                        startActivity(i);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
