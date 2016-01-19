/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.dao.impl;

import com.bishal.academy.constant.SQLConstant;
import com.bishal.academy.dao.CourseDAO;
import com.bishal.academy.dbutil.DbConnection;
import com.bishal.academy.entity.Course;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CourseDAOImpl implements CourseDAO {
    private DbConnection conn=new DbConnection();

    @Override
    public int insert(Course c) throws SQLException, ClassNotFoundException {
        conn.open();
        PreparedStatement stmt=conn.init(SQLConstant.COURSE_INSERT);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getDescription());
        stmt.setDouble(3, c.getFees());
        stmt.setInt(4, c.getDuration());
        stmt.setString(5, c.getDurationType());
        stmt.setBoolean(6, c.isStatus());
        int result=conn.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public int update(Course c) throws SQLException, ClassNotFoundException {
        conn.open();
        PreparedStatement stmt=conn.init(SQLConstant.COURSE_UPDATE);
        stmt.setString(1, c.getName());
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getDescription());
        stmt.setDouble(3, c.getFees());
        stmt.setInt(4, c.getDuration());
        stmt.setString(5, c.getDurationType());
        stmt.setDate(6, (Date) c.getModifiedDate());
        stmt.setBoolean(7, c.isStatus());
        stmt.setInt(8, c.getId());
        int result = conn.executeUpdate();
        
        conn.close();
        return result;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Course getbyId(int id) throws SQLException, ClassNotFoundException {
        Course course=null;
        conn.open();
        PreparedStatement stmt=conn.init(SQLConstant.COURSE_GETBYID);
        stmt.setInt(1, id);
        ResultSet rs=conn.executeQuery();
        while(rs.next()){
            course=mapData(rs);
        }
        conn.close();
        return course;
    }

    @Override
    public List<Course> getAll(boolean show) throws SQLException, ClassNotFoundException {
        List<Course> courseList=new ArrayList<>();
        conn.open();
        String sql=(!show)?SQLConstant.COURSE_GETALL + " WHERE status=1":SQLConstant.COURSE_GETALL;
        PreparedStatement stmt=conn.init(sql);
        ResultSet rs=conn.executeQuery();
        while(rs.next()){

            Course course=mapData(rs);
            courseList.add(course);
        }
        conn.close();
        return courseList;
    }
    
    private Course mapData(ResultSet rs) throws SQLException{
        Course course=new Course();
        course.setId(rs.getInt("id"));
        course.setName(rs.getString("course_name"));
        course.setDescription(rs.getString("course_description"));
        course.setFees(rs.getDouble("fees"));
        course.setDuration(rs.getInt("duration"));
        course.setDurationType(rs.getString("duration_type"));
        course.setAddedDate(rs.getDate("added_date"));
        course.setModifiedDate(rs.getDate("modified_date"));
        course.setStatus(rs.getBoolean("status"));
        return course;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
