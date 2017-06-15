package com.example.nt.danhba;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NT on 6/13/2017.
 */

public class DanhbaAdapter extends ArrayAdapter<danhba> {

    private Context context;
    private int resoure;
    private List<danhba> danhbaList;
    public DanhbaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<danhba> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resoure =resource;
        this.danhbaList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_danhba,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txtTen = (TextView)convertView.findViewById(R.id.txtTen);
            viewHolder.txtSodt= (TextView)convertView.findViewById(R.id.txtSodt);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.anh);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        danhba db =danhbaList.get(position);

        viewHolder.txtTen.setText(String.valueOf(db.getMten()));
        viewHolder.txtSodt.setText(String.valueOf(db.getMsdt()));

        if(db.getGioitinh()==1)
        {
             viewHolder.imageView.setBackgroundResource(R.drawable.nam);
        }
        else
        {
            viewHolder.imageView.setBackgroundResource(R.drawable.nu);
        }


        return convertView;
    }
    public  class ViewHolder
    {
        private TextView txtTen;
        private TextView txtSodt;
         ImageView imageView;
    }
}
