package com.example.dormitory.service;

import com.example.dormitory.model.Sorce;
import com.example.dormitory.model.Student;

import java.util.List;

public interface SorceService {
    List<Sorce> getAllSorces();
    void insert(Sorce sorce);
    void delete(int shushe);
    void modify(Sorce sorce);
}
