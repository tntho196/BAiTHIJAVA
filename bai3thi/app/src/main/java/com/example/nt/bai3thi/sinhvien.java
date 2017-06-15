package com.example.nt.bai3thi;

/**
 * Created by NT on 6/15/2017.
 */

public class sinhvien {
    String maso;
    String hoten;
    boolean gioitinh;

    public sinhvien(String maso, String hoten, boolean gioitinh) {
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
    }

    public sinhvien() {
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        if(this.isGioitinh())
        return  this.getMaso()+" - "+this.getHoten()+"-"+ "nam";
        return   this.getMaso()+" - "+this.getHoten()+"-"+ "nữ";
    }
}
