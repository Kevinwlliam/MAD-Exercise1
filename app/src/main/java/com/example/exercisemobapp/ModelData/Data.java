package com.example.exercisemobapp.ModelData;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Data implements Parcelable {

    private String nama, alamat, umur;

    public Data() {
        this.nama = "";
        this.alamat = "";
        this.umur = "";
    }

    public Data(String nama, String alamat, String umur) {
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
    }

    protected Data(Parcel in) {
        nama = in.readString();
        alamat = in.readString();
        umur = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(alamat);
        dest.writeString(umur);
    }
}
