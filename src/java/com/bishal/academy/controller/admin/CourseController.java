/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.controller.admin;

import com.bishal.academy.entity.Course;
import com.bishal.academy.service.CourseService;
import com.bishal.academy.service.impl.CourseServiceImpl;
import com.bishal.academy.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "AdminCourseController",urlPatterns = {"/c/*"})
public class CourseController extends Controller {
    CourseService courseService=new CourseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getRequestURI().toLowerCase();
        PrintWriter out= response.getWriter();       
        
        if(path.contains("/add")){
            request.getRequestDispatcher("/WEB-INF/Views/admin/course/add.jsp").forward(request, response);
        }
        if(path.contains("/edit")){
            if(request.getParameter("id")!=null && !request.getParameter("id").isEmpty()){
                    try{
                    int id=Integer.parseInt(request.getParameter("id"));
                    Course course=courseService.getbyId(id);
                    
                    if(course!=null){
                        request.setAttribute("c",course);
                        request.getRequestDispatcher("/WEB-INF/Views/admin/course/edit.jsp").forward(request, response);
                    }
                    else{
                        response.sendRedirect(request.getContextPath());
                    }
                    
                    
                    }catch(SQLException se){
                        
                    }catch(ClassNotFoundException ce){
                    }
                }
            
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getRequestURI().toLowerCase();
        PrintWriter out= response.getWriter(); 
        if(path.contains("/save")){
            response.getWriter().println("hi");
            
            try {
                Course c=new Course();
                c.setName(request.getParameter("name"));
                c.setDescription(request.getParameter("description"));
                c.setFees(Double.parseDouble(request.getParameter("fees")));
                c.setDuration(Integer.parseInt(request.getParameter("duration")));
                c.setDurationType(request.getParameter("durationtype"));
                c.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            
                courseService.insert(c);
                response.getWriter().println("successfully Inserted");
            } catch (SQLException ex) {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(path.contains("/update")){
               response.getWriter().println("succasasessfully Updated");         
            try {
                String message="";
                Course c=new Course();
                c.setId(Integer.parseInt(request.getParameter("id")));
                c.setName(request.getParameter("name"));
                c.setDescription(request.getParameter("description"));
                c.setFees(Double.parseDouble(request.getParameter("fees")));
                c.setDuration(Integer.parseInt(request.getParameter("duration")));
                c.setDurationType(request.getParameter("durationtype"));
                c.setModifiedDate(new Date(Calendar.getInstance().getTimeInMillis()));
                c.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            
                courseService.update(c);
                response.getWriter().println("successfully Updated");
                request.getSession().setAttribute(message,"Data Updated Successfully");
                /*request.getRequestDispatcher("/WEB-INF/Views/admin").forward(request, response);*/
                
            } catch (SQLException se) {
                out.println(se.getMessage());
            } catch (ClassNotFoundException ce) {
                out.println(ce.getMessage());
            
        }
    }
    }
    
}
