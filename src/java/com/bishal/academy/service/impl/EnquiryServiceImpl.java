/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.service.impl;

import com.bishal.academy.dao.EnquiryDAO;
import com.bishal.academy.dao.impl.EnquiryDAOImpl;
import com.bishal.academy.entity.Enquiry;
import com.bishal.academy.service.EnquiryService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class EnquiryServiceImpl implements EnquiryService {
    EnquiryDAO enquiryDAO=new EnquiryDAOImpl();
    @Override
    public int insert(Enquiry e) throws SQLException, ClassNotFoundException {
        return enquiryDAO.insert(e);
    }

    @Override
    public int update(Enquiry t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enquiry getbyId(int id) throws SQLException, ClassNotFoundException {
        return enquiryDAO.getbyId(id);
    }

    @Override
    public List<Enquiry> getAll(boolean show) throws SQLException, ClassNotFoundException {
        return enquiryDAO.getAll(show);
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
