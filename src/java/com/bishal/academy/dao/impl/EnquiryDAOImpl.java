/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.dao.impl;

import com.bishal.academy.constant.SQLConstant;
import com.bishal.academy.dao.EnquiryDAO;
import com.bishal.academy.dbutil.DbConnection;
import com.bishal.academy.entity.Course;
import com.bishal.academy.entity.Enquiry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class EnquiryDAOImpl implements EnquiryDAO {
    private DbConnection conn=new DbConnection();

    @Override
    public int insert(Enquiry e) throws SQLException, ClassNotFoundException {
        conn.open();
        PreparedStatement stmt=conn.init(SQLConstant.ENQUIRY_INSERT);
        stmt.setString(1, e.getFirstName());
        stmt.setString(2, e.getLastName());
        stmt.setString(3, e.getEmail());
        stmt.setString(4, e.getContactNo());
        stmt.setInt(5, e.getCourse().getId());
        stmt.setString(6,e.getMessage());
        int result=conn.executeUpdate();
        conn.close();
        return result;
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
        Enquiry enquiry=null;
        conn.open();
        PreparedStatement stmt=conn.init(SQLConstant.ENQUIRY_GETBYID);
        stmt.setInt(1, id);
        ResultSet rs=conn.executeQuery();
        while(rs.next()){
            enquiry=mapData(rs);
        }
        conn.close();
        return enquiry;
    }

    @Override
    public List<Enquiry> getAll(boolean show) throws SQLException, ClassNotFoundException {
        List<Enquiry> enquiryList=new ArrayList<>();
        conn.open();
        String sql=(!show)?SQLConstant.ENQUIRY_GETALL +  " WHERE is_read=1":SQLConstant.ENQUIRY_GETALL;
        PreparedStatement stmt=conn.init(sql);
        ResultSet rs=conn.executeQuery();
        while(rs.next()){

            Enquiry enquiry=mapData(rs);
            enquiryList.add(enquiry);
        }
        conn.close();
        return enquiryList;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Enquiry mapData(ResultSet rs) throws SQLException {
        Enquiry enquiry=new Enquiry();
        enquiry.setId(rs.getInt("id"));
        enquiry.setFirstName(rs.getString("first_name"));
        enquiry.setLastName(rs.getString("last_name"));
        enquiry.setEmail(rs.getString("email"));
        enquiry.setContactNo(rs.getString("contact_no"));
        enquiry.setEnquiryDate(rs.getDate("enquiry_date"));
        Course course=new Course();
        course.setId(rs.getInt("course_id"));
        enquiry.setCourse(course);
        enquiry.setMessage(rs.getString("message"));
        enquiry.setIsRead(rs.getBoolean("is_read"));
        enquiry.setParentId(rs.getInt("parent_id"));
        
        return enquiry;
    }
 
   
}
