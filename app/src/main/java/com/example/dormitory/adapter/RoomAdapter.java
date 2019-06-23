package com.example.dormitory.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dormitory.R;
import com.example.dormitory.model.Room;

import java.util.List;



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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
            holder = new ViewHolder();

            holder.tvName = convertView.findViewById(R.id.room_name);
            holder.tvExpectNumber = convertView.findViewById(R.id.room_expect);
            holder.tvRealNumber = convertView.findViewById(R.id.room_real);
            holder.tvCost = convertView.findViewById(R.id.room_cost);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Room room = rooms.get(position);
        holder.tvName.setText(String.valueOf(room.getSushe()));
        holder.tvExpectNumber.setText(String.valueOf(room.getYzpeople()));
        holder.tvRealNumber.setText(String.valueOf(room.getSzpeople()));
        holder.tvCost.setText(String.valueOf(room.getCost()));

        return convertView;
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvExpectNumber;
        TextView tvRealNumber;
        TextView tvCost;

    }
}
