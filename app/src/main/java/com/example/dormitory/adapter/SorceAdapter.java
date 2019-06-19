package com.example.dormitory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.dormitory.R;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.Sorce;
import com.example.dormitory.model.Student;

public class SorceAdapter extends BaseAdapter {
    private List<Sorce> sorces;



    public SorceAdapter(List<Sorce> sorces) {
        this.sorces = sorces;
    }

    @Override
    public int getCount() {
        return sorces.size();
    }

    @Override
    public Sorce getItem(int position) {
        return sorces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sorce, parent, false);
            holder = new ViewHolder();

            holder.sushe = convertView.findViewById(R.id.sorce_sushe);
            holder.marks = convertView.findViewById(R.id.sorce_marks);
            holder.data = convertView.findViewById(R.id.sorce_data);




            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Sorce sorce = sorces.get(position);
        holder.sushe.setText(sorce.getSushe());
        holder.marks.setText(sorce.getMarks());
        holder.data.setText(String.valueOf(sorce.getData()));
        return convertView;
    }
    static class ViewHolder {
        TextView sushe;
        TextView marks;
        TextView data;


    }
}
