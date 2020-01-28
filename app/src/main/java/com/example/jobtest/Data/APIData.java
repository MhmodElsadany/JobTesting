package com.example.jobtest.Data;


import com.example.jobtest.Model.HomeBodyResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIData {
    String BASE_URL = "http://bellman-bd.restart-technology.com/";

    @GET("api/home")
    Observable<HomeBodyResponse> getData();
}
