package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
        edUsername=findViewById(R.id.editTextAppFullName);
        edPassword=findViewById(R.id.editTextAppContactNumber);
        edEmail=findViewById(R.id.editTextAppAddressl);
        edConfirm=findViewById(R.id.editTextAppFees);
        btn = findViewById(R.id.buttonAppBack);
        tv=findViewById(R.id.textViewExistingUser);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String username=edUsername.getText().toString();
                    String email=edEmail.getText().toString();
                    String confirm=edConfirm.getText().toString();
                    String password=edPassword.getText().toString();
                    Database db=new Database(getApplicationContext(),"heal360",null,1);
                    if(username.isEmpty() ||email.isEmpty()|| password.isEmpty() || confirm.isEmpty() )
                    {
                        Toast.makeText(getApplicationContext(),"Please fill all details", Toast.LENGTH_SHORT ).show();
                    }
                    else
                    {
                        if(password.compareTo(confirm)==0)
                        {
                            if(isValid(password))
                            {
                                db.register(username,email,password);
                                Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Password must least 8 characters,having letter,digit and special symbol", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
    }


public static boolean isValid(String password)
{
    int f1=0,f2=0,f3=0;
    if(password.length()<8){
        return false;
    }
    else{
        for(int p=0;p<password.length();p++){
            if(Character.isLetter(password.charAt(p))){
                f1=1;
            }
        }
        for(int r=0;r<password.length();r++){
            if(Character.isDigit(password.charAt(r))){
                f2=1;
            }
        }
        for(int s=0;s<password.length();s++){
            char c=password.charAt(s);
            if(c>=33 && c<=46 || c==64){
                f3=1;
            }
        }
        if(f1==1 && f2==1 && f3==1)
            return true;
        return false;
    }
}
}