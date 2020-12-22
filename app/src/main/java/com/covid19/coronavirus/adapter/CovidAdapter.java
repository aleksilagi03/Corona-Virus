package com.covid19.coronavirus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.covid19.coronavirus.model.Covid;
import com.covid19.coronavirus.R;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<com.covid19.coronavirus.adapter.CovidAdapter.CovidViewHolder> {


    private Context context;
    List<Covid> covidList;

    public CovidAdapter(Context context, List<Covid> covidList) {
        this.context = context;
        this.covidList = covidList;
    }

    @NonNull
    @Override
    public com.covid19.coronavirus.adapter.CovidAdapter.CovidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new CovidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.covid19.coronavirus.adapter.CovidAdapter.CovidViewHolder holder, int position) {
        Covid covid = covidList.get(position);
        holder.positif.setText(covid.getPositif());
        holder.meninggal.setText(covid.getMeninggal());
        holder.sembuh.setText(covid.getSembuh());

    }

    @Override
    public int getItemCount() {
        return covidList.size();
    }

    public class CovidViewHolder extends RecyclerView.ViewHolder {
        TextView positif,meninggal,sembuh;
        public CovidViewHolder(@NonNull View itemView) {
            super(itemView);
            positif = itemView.findViewById(R.id.tv_positif);
            meninggal = itemView.findViewById(R.id.tv_meninggal);
            sembuh = itemView.findViewById(R.id.tv_sembuh);
        }
    }
}
