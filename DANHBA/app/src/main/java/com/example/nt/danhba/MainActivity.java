package com.example.nt.danhba;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<danhba> danhbaList;
    private EditText editTen;
    private EditText editSdt;
    private RadioButton rnam;
    private RadioButton rnu;
    private Button btnThem;
    private Button btnsua;
    public ListView lvdanhba;
    private DanhbaDatabase DBdatabase;
    private DanhbaAdapter DBadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvdanhba=(ListView)findViewById(R.id.lvd);
        anhxa();

        DBdatabase = new DanhbaDatabase(this);
        danhbaList = DBdatabase.getAllDanhba();
        setAdapter();
        lvdanhba.setAdapter(DBadapter);
        lvdanhba.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, " bạn đã  thêm thành công ",Toast.LENGTH_SHORT).show();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                them();
            }
        });




    }
    public  void anhxa()
    {
        editTen= (EditText)findViewById(R.id.editTen);
        editSdt= (EditText)findViewById(R.id.editSdt);
        rnam = (RadioButton)findViewById(R.id.raNam);
        rnu = (RadioButton)findViewById(R.id.raNu);
        btnThem =(Button)findViewById(R.id.button);

        btnsua =(Button)findViewById(R.id.btnsua);
    }
    public void them()
    {
        String ten =editTen.getText().toString().trim();
        String std =editSdt.getText().toString().trim();
        String gioitinh= "TRUE";
        if(TextUtils.isEmpty(ten)||TextUtils.isEmpty(std) )
        {
            Toast.makeText(this, " Nhập tên và số điện thoại ",Toast.LENGTH_SHORT).show();
        }
        else {
            danhba Danhba = taodb();
            if (Danhba != null) {
                DBdatabase.ThemCV(Danhba);

            }
            danhbaList.clear();
            danhbaList.addAll(DBdatabase.getAllDanhba());
            setAdapter();
            Toast.makeText(this, " bạn đã  thêm thành công ",Toast.LENGTH_SHORT).show();

        }

    }
    private void setAdapter()
    {
        if(DBadapter == null){
            DBadapter = new DanhbaAdapter(this,R.layout.item_danhba,danhbaList);
        }
        else
        {
            DBadapter.notifyDataSetChanged();
            lvdanhba.setSelection(DBadapter.getCount()-1);
        }
    }
    public  danhba  taodb()
    {
        int gioitinh= 1;
        if(rnam.isChecked())
        {
            gioitinh= 1;
        }else
            gioitinh= 0;
        String Ten = editTen.getText().toString();
        String Sdt = editSdt.getText().toString();

        danhba Danhba = new danhba(Ten,Sdt,gioitinh);
        return Danhba;
    }
    public  void showdialogconfirm()
    {
        Dialog dialog = new Dialog(this);
        ImageButton call=(ImageButton) findViewById(R.id.btncall);
        ImageButton message=(ImageButton) findViewById(R.id.btnNhantin);
        dialog.setContentView(R.layout.goivanhantin);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
