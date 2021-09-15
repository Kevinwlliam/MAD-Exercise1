package com.example.exercisemobapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.exercisemobapp.ModelData.Data;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.DataViewHolder> {

    private ArrayList<Data> listData;
    private Context context;

    public UserAdapter(Context context, ArrayList<Data>listData){
        this.listData = listData;
        this.context = context;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_data, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.card_data_nama.setText(listData.get(position).getNama());
        holder.card_data_alamat.setText(listData.get(position).getAlamat());
        holder.card_data_umur.setText(listData.get(position).getUmur());

        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = listData.get(position).getNama();
                String umur = listData.get(position).getUmur();
                String alamat = listData.get(position).getAlamat();

                Intent intent = new Intent(context, DetailsData.class);
                intent.putExtra("Nama", nama);
                intent.putExtra("Umur", umur);
                intent.putExtra("Alamat", alamat);
                intent.putExtra("position", position);

                ((Activity) context).startActivityForResult(intent, 888);
                // context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {return listData.size();}

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView card_data_nama, card_data_alamat, card_data_umur;
        private ImageView card_data_logo;
        private ConstraintLayout parentlayout;

        public DataViewHolder(@NonNull View itemView){
            super(itemView);
            card_data_nama = itemView.findViewById(R.id.card_data_nama);
            card_data_alamat = itemView.findViewById(R.id.card_data_alamat);
            card_data_umur = itemView.findViewById(R.id.card_data_umur);
            card_data_logo = itemView.findViewById(R.id.card_data_logo);
            parentlayout = itemView.findViewById(R.id.parentlayout);
        }

    }
}
