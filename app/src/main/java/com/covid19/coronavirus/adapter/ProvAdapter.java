package com.covid19.coronavirus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.covid19.coronavirus.model.Provinsi.CovidResponse;
import com.covid19.coronavirus.R;

import java.util.List;

public class ProvAdapter extends RecyclerView.Adapter<ProvAdapter.ProvinsiViewHolder>{
    private Context context;
    private List<CovidResponse> attributesList;

    public ProvAdapter(Context context, List<CovidResponse> attributesList) {
        this.context = context;
        this.attributesList = attributesList;
    }

    @NonNull
    @Override
    public ProvAdapter.ProvinsiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_provinsi,parent,false);
        return new ProvinsiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvAdapter.ProvinsiViewHolder holder, int position) {

        CovidResponse covidResponse = attributesList.get(position);
        holder.positif.setText(String.valueOf(covidResponse.getAttributes().getKasusPosi()));
        holder.meninggal.setText(String.valueOf(covidResponse.getAttributes().getKasusMeni()));
        holder.sembuh.setText(String.valueOf(covidResponse.getAttributes().getKasusSemb()));
        holder.provinsi.setText(covidResponse.getAttributes().getProvinsi());
    }

    @Override
    public int getItemCount() {
        return attributesList.size();
    }

    public static class ProvinsiViewHolder extends RecyclerView.ViewHolder {
        TextView positif,meninggal,sembuh,provinsi;
        public ProvinsiViewHolder(@NonNull View itemView) {
            super(itemView);
            positif = itemView.findViewById(R.id.tv_positif);
            meninggal = itemView.findViewById(R.id.tv_meninggal);
            sembuh = itemView.findViewById(R.id.tv_sembuh);
            provinsi = itemView.findViewById(R.id.tv_provinsi);

        }
    }
}
