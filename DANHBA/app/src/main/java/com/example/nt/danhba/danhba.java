package com.example.nt.danhba;

/**
 * Created by NT on 6/13/2017.
 */

public class danhba {
    private int mmadb;

    private String mten;
    private String msdt;
    private int gioitinh;

    public danhba(int mmadb, String mten, String msdt, int gioitinh) {
        this.mmadb = mmadb;
        this.mten = mten;
        this.msdt = msdt;
        this.gioitinh = gioitinh;
    }

    public  danhba()
    {

    }
    public danhba(String mten, String msdt, int gioitinh) {
        this.mten = mten;
        this.msdt = msdt;
        this.gioitinh = gioitinh;
    }

    public int getMmadb() {
        return mmadb;
    }

    public void setMmadb(int mmadb) {
        this.mmadb = mmadb;
    }

    public String getMten() {
        return mten;
    }

    public void setMten(String mten) {
        this.mten = mten;
    }

    public String getMsdt() {
        return msdt;
    }

    public void setMsdt(String msdt) {
        this.msdt = msdt;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }
}
