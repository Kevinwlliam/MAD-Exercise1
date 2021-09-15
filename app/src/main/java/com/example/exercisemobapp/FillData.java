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

public class FillData extends AppCompatActivity {

    private TextInputLayout inputdata_nama, inputdata_alamat, inputdata_umur;
    private Button inputdata_button;
    /*ProgressDialog loadingdialog;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_data);
        getSupportActionBar().hide();

        inputdata_nama = findViewById(R.id.inputdata_nama);
        inputdata_alamat = findViewById(R.id.inputdata_alamat);
        inputdata_umur = findViewById(R.id.inputdata_umur);
        inputdata_button = findViewById(R.id.inputdata_button);
        final LoadingDialog loadingDialog = new LoadingDialog(FillData.this);

/*        inputdata_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingdialog = new ProgressDialog(getBaseContext());
                loadingdialog.show();
                loadingdialog.setContentView(R.layout.progress);
                loadingdialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        String nama = inputdata_nama.getEditText().getText().toString().trim();
                        String alamat = inputdata_alamat.getEditText().getText().toString().trim();
                        String umur = inputdata_umur.getEditText().getText().toString().trim();
                        Data temp = new Data(nama, alamat, umur);
                        Data.tesdata.add(temp);

                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        intent.putExtra("Tester", temp);
                        startActivity(intent);
                        setResult(200, intent);
                        finish();
                    }
                });*/
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
                        setResult(200, intent);
                        loadingDialog.dismissDialog();
                        finish();
                    }
                }, 5000);
            }
        });

    }
};