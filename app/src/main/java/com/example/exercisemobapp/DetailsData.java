package com.example.exercisemobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsData extends AppCompatActivity {

    private TextView usernama_detail, userumur_detail, useralamat_detail;
    private Button editbutton_detail, deletebutton_detail;
    private Intent intent;
    private String nama, umur, alamat;
    private int position;
    private LoadingDialog loadingdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().hide();

        Initview();
        Initintent();
        setListener();
    }
    private void Initview(){
        usernama_detail = findViewById(R.id.usernama_detail);
        userumur_detail = findViewById(R.id.userumur_detail);
        useralamat_detail = findViewById(R.id.useralamat_detail);
        editbutton_detail = findViewById(R.id.editbutton_detail);
        deletebutton_detail = findViewById(R.id.deletebutton_detail);
        loadingdialog = new LoadingDialog(DetailsData.this);

        intent = getIntent();
    }

    private void Initintent(){
        nama = intent.getStringExtra("Nama");
        umur = intent.getStringExtra("Umur");
        alamat = intent.getStringExtra("Alamat");
        position = intent.getIntExtra("position", 0);
        usernama_detail.setText(nama);
        userumur_detail.setText((umur + " Tahun"));
        useralamat_detail.setText(alamat);
    }

    private void setListener(){
        editbutton_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Nama", nama);
                intent.putExtra("Umur", umur);
                intent.putExtra("Alamat", alamat);
                intent.putExtra("position", position);
                setResult(101, intent);
                finish();
            }
        });

        deletebutton_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingdialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.putExtra("position", position);
                        setResult(100, intent);
                        loadingdialog.dismissDialog();
                        finish();
                    }
                }, 3000);
            }
        });
    }

}