/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DAO.Impl;

import com.puzan.testground.DAO.AmountDAO;
import com.puzan.testground.DTO.AmountDTO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzan
 */
@Repository(value = "AmountDAO")
public class AmountDAOImpl implements AmountDAO {

    @Autowired
    private SessionFactory sf;
    private Session session;
    private Transaction transaction;

    @Override
    public List<AmountDTO> getAll() {
        session = sf.openSession();
        String sql = "select e.enrollment_id,IFNULL(SUM(p.amount),0)from tbl_enrollments e LEFT JOIN  tbl_payments p on p.enrollment_id = e.enrollment_id GROUP BY e.enrollment_id";
        SQLQuery query = session.createSQLQuery(sql);
        List<AmountDTO> amountList = new ArrayList<>();
        List<Object[]> recs = query.list();
        for (Object[] line : recs) {
            AmountDTO amount = new AmountDTO();
            amount.setEnrollmentId(Integer.parseInt(line[0].toString()));
            amount.setAmount(Float.parseFloat(line[1].toString()));
            amountList.add(amount);
        }
        session.close();
        return amountList;
    }

}
