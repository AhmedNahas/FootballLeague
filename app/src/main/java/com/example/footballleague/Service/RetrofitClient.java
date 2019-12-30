package com.example.footballleague.Service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {



    private static Retrofit INSTANCE = null;

        public static Retrofit getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new Retrofit.Builder()
                    .baseUrl("http://api.football-data.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }

}
