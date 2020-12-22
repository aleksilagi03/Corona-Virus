package com.covid19.coronavirus.tampilan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.covid19.coronavirus.adapter.ProvAdapter;
import com.covid19.coronavirus.connect.call;
import com.covid19.coronavirus.connect.Configuration;
import com.covid19.coronavirus.model.Provinsi.CovidResponse;
import com.covid19.coronavirus.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusCovidActivity extends AppCompatActivity {

    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasus_covid);

        rv = findViewById(R.id.rv_provinsi);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        getdata();
    }

    private void getdata(){

        final call api = Configuration.getRetrofit().create(call.class);
        Call<List<CovidResponse>> callapi = api.getDataProvinsiCovidIndonesia();
        callapi.enqueue(new Callback<List<CovidResponse>>() {
            @Override
            public void onResponse(Call<List<CovidResponse>> call, Response<List<CovidResponse>> response) {
                List<CovidResponse> covidResponseList = response.body();
                ProvAdapter ProvAdapter = new ProvAdapter(com.covid19.coronavirus.tampilan.KasusCovidActivity.this, covidResponseList);
                rv.setItemAnimator(new DefaultItemAnimator());
                rv.setAdapter(ProvAdapter);


            }

            @Override
            public void onFailure(Call<List<CovidResponse>> call, Throwable t) {

            }
        });
    }
}
