/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DAO.Impl;

import com.puzan.testground.DAO.BookDAO;
import com.puzan.testground.Entities.Book;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzan
 */
@Repository(value = "BookDAO")
public class BookDAOImpl extends GenericDAOImpl<Book> implements BookDAO {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Session session;

    @Override
    public List<Book> search(String q) {
        session = sessionFactory.openSession();
        String hql = "from Book where name LIKE :searchKeyword";
        Query query = session.createQuery(hql);
        query.setParameter("searchKeyword", "%" + q + "%");
        List<Book> bookList = query.list();
        session.close();
        return bookList;
    }

    @Override
    public Book save(Book b) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(b);
        transaction.commit();
        session.close();
        return b;
    }
}
