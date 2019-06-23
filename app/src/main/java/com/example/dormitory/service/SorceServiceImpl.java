package com.example.dormitory.service;

import android.content.Context;

import com.example.dormitory.dao.SorceDao;
import com.example.dormitory.dao.SorceDaoImpl;
import com.example.dormitory.dao.StudentDao;
import com.example.dormitory.dao.StudentDaoImpl;
import com.example.dormitory.model.Sorce;
import com.example.dormitory.model.Student;

import java.util.List;

public class SorceServiceImpl implements SorceService{
    private SorceDao sorceDao;

    public SorceServiceImpl(Context context) {
        sorceDao = new SorceDaoImpl(context);
    }

    @Override
    public List<Sorce> getAllSorces() {
        return sorceDao.selectAllsorce();
    }


    public void insert(Sorce sorce) {
        sorceDao.insert(sorce);
    }

    @Override
    public void delete(int shushe) {
        sorceDao.delete(Integer.parseInt(String.valueOf(shushe)));
    }

    public void modify(Sorce sorce) {
        sorceDao.update(sorce);
    }
}
