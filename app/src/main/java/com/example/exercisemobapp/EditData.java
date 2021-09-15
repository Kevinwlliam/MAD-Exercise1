package com.example.exercisemobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.exercisemobapp.ModelData.Data;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class EditData extends AppCompatActivity {

    private TextInputLayout inputdata_nama, inputdata_alamat, inputdata_umur;
    private Button inputdata_button;
    private Intent intent;
    private String nama, umur, alamat;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        getSupportActionBar().hide();

        inputdata_nama = findViewById(R.id.inputdata_nama);
        inputdata_alamat = findViewById(R.id.inputdata_alamat);
        inputdata_umur = findViewById(R.id.inputdata_umur);
        inputdata_button = findViewById(R.id.inputdata_button);
        final LoadingDialog loadingDialog = new LoadingDialog(EditData.this);

        intent = getIntent();
        nama = intent.getStringExtra("Nama");
        umur = intent.getStringExtra("Umur");
        alamat = intent.getStringExtra("Alamat");
        position = intent.getIntExtra("position", 0);
        inputdata_nama.getEditText().setText(nama);
        inputdata_umur.getEditText().setText(umur);
        inputdata_alamat.getEditText().setText(alamat);

        inputdata_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        String nama = inputdata_nama.getEditText().getText().toString().trim();
                        String alamat = inputdata_alamat.getEditText().getText().toString().trim();
                        String umur = inputdata_umur.getEditText().getText().toString().trim();

                        Data temp = new Data(nama, alamat, umur);

                        Intent intent = new Intent();
                        intent.putExtra("DataBaru", temp);
                        intent.putExtra("position", position);
                        setResult(102, intent);
                        loadingDialog.dismissDialog();
                        finish();
                    }
                }, 5000);
            }
        });

    }
};