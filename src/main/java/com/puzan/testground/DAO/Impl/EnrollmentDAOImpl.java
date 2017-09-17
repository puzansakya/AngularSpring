/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DAO.Impl;

import com.puzan.testground.DAO.EnrollmentDAO;
import com.puzan.testground.DAO.GenericDAO;
import com.puzan.testground.Entities.Enrollment;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzan
 */
@Repository(value = "EnrollmentDAO")
public class EnrollmentDAOImpl extends GenericDAOImpl<Enrollment> implements EnrollmentDAO {

}
