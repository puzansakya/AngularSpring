/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DAO.Impl;

import com.puzan.testground.DAO.CategoryDAO;
import com.puzan.testground.Entities.Category;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzan
 */
@Repository(value = "CategoryDAO")
public class CategoryDAOImpl extends GenericDAOImpl<Category> implements CategoryDAO{
    
}
