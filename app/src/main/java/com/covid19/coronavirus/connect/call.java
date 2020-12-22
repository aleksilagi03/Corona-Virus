package com.covid19.coronavirus.connect;

import com.covid19.coronavirus.model.Covid;
import com.covid19.coronavirus.model.Provinsi.CovidResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface call {


    @GET("indonesia/")
    Call<List<Covid>> getDataCovidIndonesia();

    @GET("indonesia/provinsi/")
    Call<List<CovidResponse>> getDataProvinsiCovidIndonesia();

}