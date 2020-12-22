package com.covid19.coronavirus.connect;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configuration {


    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.kawalcorona.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}

