package com.module3.service;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IGenaricService<T>{
    List<T>findAll();
    T save (int id, T t);
    T edit (int id, T t);
    T findById (int id);
    void delete (int id);
}
