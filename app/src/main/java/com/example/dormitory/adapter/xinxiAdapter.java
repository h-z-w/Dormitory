package com.example.dormitory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dormitory.R;
import com.example.dormitory.model.Student;
import com.example.dormitory.model.Xinxi;
import com.example.dormitory.ui.LookActivity;

import java.util.List;

public class xinxiAdapter extends BaseAdapter {
    private List<Xinxi> xinxis;

    public xinxiAdapter(List<Xinxi> xinxis) {
        this.xinxis = xinxis;
    }

    public xinxiAdapter(LookActivity lookActivity, int student_score_item, List<Student> list) {

    }

    @Override
    public int getCount() {
        return xinxis.size();
    }

    @Override
    public Object getItem(int position) {
        return xinxis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_add, null);
            holder=new ViewHolder();
            holder.tvxHao=convertView.findViewById(R.id.xh);
            holder.tvName=convertView.findViewById(R.id.name);
            holder.tvClass=convertView.findViewById(R.id.classroom);
            holder.tvSex=convertView.findViewById(R.id.sex);
            holder.tvSuShe=convertView.findViewById(R.id.shuse);
            holder.tvTel=convertView.findViewById(R.id.tel);
            holder.tvDate=convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        Xinxi xinxi=xinxis.get(position);
        holder.tvxHao.setText(xinxi.getXh());
        holder.tvName.setText(xinxi.getName());
        holder.tvClass.setText(xinxi.getClassName());
        holder.tvSex.setText(xinxi.getSex());
        holder.tvSuShe.setText(xinxi.getShuShe());
        holder.tvTel.setText(String.valueOf(xinxi.getTel()));
        holder.tvDate.setText(xinxi.getSubmissionDate());
        return convertView;
    }
    static class ViewHolder{
        TextView tvxHao;
        TextView tvName;
        TextView tvClass;
        TextView tvSex;
        TextView tvSuShe;
        TextView tvTel;
        TextView tvDate;
    }
}

