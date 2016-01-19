/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public interface GenericService<T> {
    int insert(T t)throws SQLException,ClassNotFoundException;
    int update(T t)throws SQLException,ClassNotFoundException;
    int delete(int id)throws SQLException,ClassNotFoundException;
    T getbyId(int id)throws SQLException,ClassNotFoundException;
    List<T> getAll(boolean show)throws SQLException,ClassNotFoundException;
    int count()throws SQLException,ClassNotFoundException;
}
