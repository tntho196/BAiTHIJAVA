package com.example.nt.chuyendoinhietdo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ctof;
    Button ftoc;
    EditText editdoc;
    EditText editdof;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctof= (Button)findViewById(R.id.btnctof);
        ftoc= (Button)findViewById(R.id.btnftoc);
        editdoc=(EditText)findViewById(R.id.editdoc);
        editdof=(EditText)findViewById(R.id.editdof);

        txtkq=(TextView)findViewById(R.id.kq);

        ctof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float doc;
                float dof;
                doc=Float.parseFloat( editdoc.getText().toString());
                dof=doc*(9/5)+32;
                txtkq.setText(dof+"");

            }
        });
        ftoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float doc;
                float dof;
                dof=Float.parseFloat( editdof.getText().toString());
                doc= (dof-32)*((float) 5/9);
                txtkq.setText(doc+"");
            }
        });
    }
}
