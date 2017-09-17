/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DAO;

import java.util.List;

/**
 *
 * @author puzan
 */
public interface GenericDAO<T> {

    List<T> getAll();

    int insert(T t);

    void delete(int id);

    void update(T t);

    T getById(int id);

}
