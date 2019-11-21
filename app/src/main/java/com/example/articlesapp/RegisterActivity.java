package com.example.articlesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText enterNameEn,createEmailCe,createPasswordCp,enterBirthdateEb;
    Spinner citiesS;
    TextView loginTV ,maleTv , femaleTv;
    String[] contry = {"select city","Alx","Bni Suif","cairo","Luxor","Aswan","Hurghada","menofia"};
//    AppDataKeyValue appDataKeyValue;
    Button registerBtn;
    String city="";
    String gender;


    final Calendar myCalendar = Calendar.getInstance();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setReferneceOfViews();
        citiesS.setOnItemSelectedListener(this);
        ArrayAdapter aa= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,contry);
        citiesS.setAdapter(aa);

//        appDataKeyValue =new AppDataKeyValue(this);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkData();


            }
        });
        saveDataInShared();


        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateViewOnScreen();
            }

        };
        enterBirthdateEb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RegisterActivity.this, dateListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(RegisterActivity.this,LoginActicity.class);
                startActivity(intent);
                finish();
            }
        });
        maleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "male";
                maleTv.setTag("1");
                femaleTv.setTag("0");
                maleTv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                femaleTv.setBackgroundColor(getResources().getColor(R.color.gray));

            }
        });
        femaleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "female";
                maleTv.setTag("0");
                femaleTv.setTag("1");
                maleTv.setBackgroundColor(getResources().getColor(R.color.gray));
                femaleTv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });





    }



    private void updateViewOnScreen() {
        String myFormat = "dd/mm/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        enterBirthdateEb.setText(sdf.format(myCalendar.getTime()));
    }


    private void checkData(){
        if (enterNameEn.getText().toString().equals("")){
            Toast.makeText(this,"enter name", Toast.LENGTH_LONG).show();
        }
        else if (createEmailCe.getText().toString().equals("")){
            Toast.makeText(this,"enter email",Toast.LENGTH_LONG).show();
        }
        else if (createPasswordCp.getText().toString().length()>6){
            Toast.makeText(this,"enter valid password",Toast.LENGTH_LONG).show();
        }

        else if (enterBirthdateEb.getText().toString().equals("")){
            Toast.makeText(this,"select birsdate",Toast.LENGTH_LONG).show();
        }

        else if (city.equals("")){
            Toast.makeText(this,"select city",Toast.LENGTH_LONG).show();
        }
        else if (gender.equals("")){
            Toast.makeText(this,"select gender",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Register Successfully",Toast.LENGTH_LONG).show();
        }

    }



    private void saveDataInShared()
    {
        SharedPreferences sharedPreferences =
                getSharedPreferences("articlesData" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("name" , enterNameEn.getText().toString());
        editor.putString("email" , createEmailCe.getText().toString());
        editor.putString("password" , createPasswordCp.getText().toString());
        editor.putString("Birthdate" ,enterBirthdateEb.getText().toString());
        editor.putString("city" , city);
        editor.putString("gender" , gender);

        editor.commit();

        Toast.makeText(this,sharedPreferences.getString("name" , "not found"),
                Toast.LENGTH_LONG).show();

    }




    private void setReferneceOfViews(){

        enterNameEn=findViewById(R.id.editText3);
        createEmailCe=findViewById(R.id.editText5);
        createPasswordCp=findViewById(R.id.editText6);
        enterBirthdateEb=findViewById(R.id.editText9);
        citiesS=findViewById(R.id.spinner);
        registerBtn=findViewById(R.id.button2);
        loginTV=findViewById(R.id.textView13);
        maleTv=findViewById(R.id.textView11);
        femaleTv=findViewById(R.id.textView10);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//        Toast.makeText(this,contry[position],Toast.LENGTH_LONG).show();
        city = contry[position];


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
