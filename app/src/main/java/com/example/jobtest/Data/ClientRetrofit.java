package com.example.jobtest.Data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRetrofit {
    private static Retrofit ourInstance;

    private ClientRetrofit() {
    }

    public static Retrofit getInstance() {
        ourInstance = new Retrofit.Builder().baseUrl(APIData.BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return ourInstance;
    }


}
