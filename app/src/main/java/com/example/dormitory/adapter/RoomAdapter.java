package com.example.dormitory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.dormitory.R;
import com.example.dormitory.model.Room;

public class RoomAdapter extends BaseAdapter {
    private List<Room> rooms;

    public RoomAdapter(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Room getItem(int position) {
        return rooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
            holder = new ViewHolder();

            holder.name = convertView.findViewById(R.id.student_name1);
            holder.classname = convertView.findViewById(R.id.student_class);
            holder.xh = convertView.findViewById(R.id.student_xh);
            holder.sex = convertView.findViewById(R.id.student_sex);
            holder.tel = convertView.findViewById(R.id.student_tel);
            holder.shushe = convertView.findViewById(R.id.student_shushe);
            holder.time = convertView.findViewById(R.id.student_time);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Room room = rooms.get(position);
        holder.name.setText(room.getName());
        holder.classname.setText(String.valueOf(room.getClassroom()));
        holder.xh.setText(String.valueOf(room.getXh()));
        holder.sex.setText(String.valueOf(room.getSex()));
        holder.tel.setText(String.valueOf(room.getTel()));
        holder.shushe.setText(String.valueOf(room.getShushe()));
        holder.time.setText(String.valueOf(room.getSex()));
        return convertView;
    }
    static class ViewHolder {
        TextView name;
        TextView classname;
        TextView xh;
        TextView sex;
        TextView tel;
        TextView shushe;
        TextView time;

    }
}
