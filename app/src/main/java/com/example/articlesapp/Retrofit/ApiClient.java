package com.example.articlesapp.Retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public final String BASE_URL = "https://api.themoviedb.org/3/";
    public final static String IMAGE_PATH = "https://image.tmdb.org/t/p/w500/";

    private Retrofit retrofit = null;
    private Context context;
//    private SessionManager sessionManager;

    public ApiClient(Context context)
    {
        this.context = context;
//        sessionManager = new SessionManager(context);
    }


    public Retrofit getClient()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();

        if(retrofit == null)
        {
            String url;

            url = BASE_URL;

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
