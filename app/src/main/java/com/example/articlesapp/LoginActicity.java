package com.example.articlesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActicity extends AppCompatActivity {

    EditText EnterEmailEl,enterPasswordEp;
    Button loginL;
    TextView registerR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acticity);
        setReferneceOfViews();
    }
    private void setReferneceOfViews(){
        EnterEmailEl=findViewById(R.id.editText);
        enterPasswordEp=findViewById(R.id.editText2);
        loginL=findViewById(R.id.button);
        registerR=findViewById(R.id.textView4);
    }
}
