//package com.example.articlesapp;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//public class AppDataKeyValue {

//    private SharedPreferences sharedPreferences;
//
//    private SharedPreferences.Editor editor;
//
//    public AppDataKeyValue(Context context)
//    {
//        sharedPreferences = context.getSharedPreferences("articlesData" , Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//    }
//
//
//    public String getCity(){return sharedPreferences.getString("city"," ");}
//
//    public void setCity(String city){
//
//        editor.putString("city" , city);
//        editor.commit();
//    }

//}
