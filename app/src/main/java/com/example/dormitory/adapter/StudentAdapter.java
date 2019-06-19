package com.example.dormitory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.dormitory.R;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.Student;

public class StudentAdapter extends BaseAdapter {
    private List<Student> students;



    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
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
            holder.sushe = convertView.findViewById(R.id.student_shushe);
            holder.time = convertView.findViewById(R.id.student_time);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Student student = students.get(position);
        holder.name.setText(student.getName());
        holder.classname.setText(student.getClassName());
        holder.xh.setText(String.valueOf(student.getXh()));
        holder.sex.setText(student.getSex());
        holder.tel.setText(student.getTel());
        holder.sushe.setText(String.valueOf(student.getShuShe()));
        holder.time.setText(student.getSubmissionDate());
        return convertView;
    }
    static class ViewHolder {
        TextView name;
        TextView classname;
        TextView xh;
        TextView sex;
        TextView tel;
        TextView sushe;
        TextView time;

    }
}
