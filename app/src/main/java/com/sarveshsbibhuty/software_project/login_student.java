package com.sarveshsbibhuty.software_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_student extends AppCompatActivity {


    EditText user,password;
    Button login;
    TextView signupbtn;
    String value;

    @Override
    public void onBackPressed() {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_student);

        user = (EditText)  findViewById(R.id.username_stud);
        password =(EditText) findViewById(R.id.password_stud);
        login= (Button)findViewById(R.id.login_stud);
        signupbtn = (TextView) findViewById(R.id.upbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String reg = user.getText().toString();
                final String pass = password.getText().toString();


                if (TextUtils.isEmpty(reg)) {
                    Toast.makeText(getApplicationContext(), "Enter registration number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }


                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                DatabaseReference ref1 =ref.child("Students");
                DatabaseReference ref2 =ref1.child(reg);
                DatabaseReference ref3=ref2.child("password");

                ref3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        value=dataSnapshot.getValue(String.class);

                        if(value.equals(pass)) {

                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("reg",reg);
                            editor.commit();


                            Intent intent=new Intent(login_student.this,student_page.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Incorrect Input",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login_student.this,signup_student.class);
                startActivity(i);
            }
        });
    }
}
