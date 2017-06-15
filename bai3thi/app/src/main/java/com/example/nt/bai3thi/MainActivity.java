package com.example.nt.bai3thi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<sinhvien> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView) findViewById(R.id.list);
        arrayList = new ArrayList<>();
        arrayList.add(new sinhvien("A001","NGuyen van a",true));
        arrayList.add(new sinhvien("A001","NGuyen van a",false));
        arrayList.add(new sinhvien("A001","NGuyen van a",true));
        arrayList.add(new sinhvien("A001","NGuyen van a",false));
        arrayList.add(new sinhvien("A001","NGuyen van a",true));
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_2,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
