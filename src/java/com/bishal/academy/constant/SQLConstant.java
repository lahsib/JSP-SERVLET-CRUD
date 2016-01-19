/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.constant;

/**
 *
 * @author admin
 */
public class SQLConstant {
    /** COURSE **/
    public final static String COURSE_INSERT="INSERT INTO " + TableConstant.COURSE
            + "(course_name,course_description,fees,duration,duration_type,status)"
            +" VALUEs(?,?,?,?,?,?)";
    public final static String COURSE_UPDATE="UPDATE tbl_courses SET course_name=?,course_description=?,fees=?,duration=?,duration_type=?,modified_date=?,status=? where id=?";
    public final static String COURSE_GETALL="SELECT * FROM " + TableConstant.COURSE;
    
    public final static String COURSE_GETBYID="SELECT * FROM "+ TableConstant.COURSE
            + " WHERE id=?";
    
    /** COURSE END **/
    
    /** Enquiry **/
    public final static String ENQUIRY_INSERT="INSERT INTO " + TableConstant.ENQUIRY
            + "(first_name,last_name,email,contact_no,course_id,message) VALUES(?,?,?,?,?,?)";
    public final static String ENQUIRY_GETALL="SELECT * FROM " + TableConstant.ENQUIRY;
    public final static String ENQUIRY_GETBYID="SELECT * FROM "+ TableConstant.ENQUIRY
            + " WHERE id=?";
}
