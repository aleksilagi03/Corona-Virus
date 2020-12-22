package com.covid19.coronavirus.tampilan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.covid19.coronavirus.adapter.CovidAdapter;
import com.covid19.coronavirus.connect.call;
import com.covid19.coronavirus.connect.Configuration;
import com.covid19.coronavirus.model.Covid;
import com.covid19.coronavirus.R;
import com.covid19.coronavirus.tampilan.KasusCovidActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentHome extends Fragment {


    private RecyclerView recyclerView;
    private List<Covid> covidList = new ArrayList<>();
    private ShimmerFrameLayout shimmerFrameLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rv);
        shimmerFrameLayout = view.findViewById(R.id.shimmer_layout);

        getData();
        iniFindViews(view);

        return view;
    }

    private void iniFindViews(View view){
        TextView textViewTime = view.findViewById(R.id.textView);
        String time = DateFormat.getDateTimeInstance().format(new Date());
        textViewTime.setText(time);
        TextView textView = view.findViewById(R.id.textView3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), KasusCovidActivity.class));
            }
        });
    }

    private void getData(){
        call apiService = Configuration.getRetrofit().create(call.class);
        Call<List<Covid>> call = apiService.getDataCovidIndonesia();
        call.enqueue(new Callback<List<Covid>>() {
            @Override
            public void onResponse(Call<List<Covid>> call, Response<List<Covid>> response) {
                covidList = response.body();
                CovidAdapter covidAdapter = new CovidAdapter(getContext(),covidList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(covidAdapter);
                shimmerFrameLayout.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Covid>> call, Throwable t) {

            }
        });
    }
}
