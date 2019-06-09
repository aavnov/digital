package com.example.licensecheck.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.licensecheck.Entity.Data;
import com.example.licensecheck.R;

import org.w3c.dom.Text;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.LicenseViewHolder> {

    public static class LicenseViewHolder extends RecyclerView.ViewHolder {


        TextView id;
        TextView email;

        TextView name;
        TextView inn;

 /*       ogrn,
        activity_type,
        asddress,
        date_register,
        date_termination).get();*/


        LicenseViewHolder(View itemView) {
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.id);
            email = (TextView)itemView.findViewById(R.id.email);
            name = (TextView)itemView.findViewById(R.id.name);
            inn = (TextView)itemView.findViewById(R.id.inn);

        }
    }

    List<Data> datas;

    public RVAdapter(List<Data> datas){
        this.datas = datas;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public LicenseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        LicenseViewHolder pvh = new LicenseViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(LicenseViewHolder personViewHolder, int i) {
        personViewHolder.id.setText(datas.get(i).id);
        personViewHolder.email.setText(datas.get(i).email);
        personViewHolder.name.setText("datas.get(i).email");
        personViewHolder.inn.setText("datas.get(i).email");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
