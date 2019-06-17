package com.example.dormitory.service;

import android.content.Context;

import com.example.dormitory.dao.XinxiDao;
import com.example.dormitory.dao.StudentDaoImpl;
import com.example.dormitory.model.Xinxi;

import java.util.List;

public class XinxiService {
    private Context context;
    private XinxiDao xinxiDao;
    public XinxiService(Context context){
        this.context = context;
        xinxiDao = (XinxiDao) new StudentDaoImpl(context);
    }
    public List<Xinxi> getAllXinxis(){
        return xinxiDao.selectAllXinxi();
    }
    public void insert(Xinxi xinxi){
        xinxiDao.insert(xinxi);
    }
}
