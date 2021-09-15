package com.example.exercisemobapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import com.example.exercisemobapp.ModelData.Data;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recylerview_listdata;
    private ArrayList<Data> dataUser;
    private UserAdapter adapter;
    private FloatingActionButton recyclerView_FAB_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        DataView();
        setupRecyclerView();
       /* addSumData();*/
        setListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == 200){
                Data DataBaru = data.getParcelableExtra("DataBaru");
                dataUser.add(DataBaru);
                adapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 888){
            if (resultCode == 100){
                int position = data.getIntExtra("position", 0);
                dataUser.remove(position);
                adapter.notifyDataSetChanged();
            }
            if (resultCode == 101){
                String nama = data.getStringExtra("Nama");
                String umur= data.getStringExtra("Umur");
                String alamat = data.getStringExtra("Alamat");
                int position = data.getIntExtra("position", 0);

                Intent intent = new Intent(getBaseContext(), EditData.class);
                intent.putExtra("Nama", nama);
                intent.putExtra("Umur", umur);
                intent.putExtra("Alamat", alamat);
                intent.putExtra("position", position);
                startActivityForResult(intent, 101);
            }
        }
        if (requestCode == 101){
            if (resultCode == 102){
                Data DataBaru = data.getParcelableExtra("DataBaru");
                int position = data.getIntExtra("position", 0);
                dataUser.set(position, DataBaru);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void setListener() {
        recyclerView_FAB_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FillData.class);
                startActivityForResult(intent, 1);
            }
        });
    }

/*    private void addSumData() {
        dataUser.add(new Data("Kevin William", "Samarinda", "18"));
        adapter.notifyDataSetChanged();
    }*/

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recylerview_listdata.setLayoutManager(manager);
        recylerview_listdata.setAdapter(adapter);
    }

    private void DataView() {
        recylerview_listdata = findViewById(R.id.recylerview_listdata);
        dataUser = new ArrayList<Data>();
        adapter = new UserAdapter(this, dataUser);
        recyclerView_FAB_add = findViewById(R.id.recyclerView_FAB_add);
    }

}