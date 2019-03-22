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

public class signup_student extends AppCompatActivity {

    EditText name,school,reg,password;
    Button btnup;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_student);

        name = (EditText) findViewById(R.id.student_name);
        school = (EditText) findViewById(R.id.school_name_stud);
        reg = (EditText) findViewById(R.id.reg);
        password = (EditText) findViewById(R.id.pass_stud);
        btnup = (Button) findViewById(R.id.signup_stud);



        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String na = name.getText().toString();
                final String school_stud =  school.getText().toString();
                final String registration_no = reg.getText().toString();
                final String pass = password.getText().toString();



                if (TextUtils.isEmpty(na)) {
                    Toast.makeText(getApplicationContext(), "Enter your Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(school_stud)) {
                    Toast.makeText(getApplicationContext(), "Enter School", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(registration_no)) {
                    Toast.makeText(getApplicationContext(), "Enter registration number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseDatabase database = FirebaseDatabase.getInstance();


                final DatabaseReference myRef = database.getReference("Students").child(registration_no);

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){

                    //        Toast.makeText(getApplicationContext(), "Account Exists", Toast.LENGTH_SHORT).show();

                        }

                        else {


                            myRef.child("name").setValue(na);
                            myRef.child("reg").setValue(registration_no);
                            myRef.child("schoolname").setValue(school_stud);
                            myRef.child("password").setValue(pass);


                            Toast.makeText(getApplicationContext(), "Account successfully made.Please Login", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(signup_student.this, login_student.class);
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
