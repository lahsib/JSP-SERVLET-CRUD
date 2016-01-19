/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.controller;

import com.bishal.academy.dbutil.DbConnection;
import com.bishal.academy.entity.Course;
import com.bishal.academy.service.CourseService;
import com.bishal.academy.service.impl.CourseServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "default" ,urlPatterns = {"/"})
public class DefaultController extends HttpServlet {
    CourseService courseService=new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setHeader("Content-Type", "text/html");
        try{
        
            request.setAttribute("courses",courseService.getAll(false));
            request.getRequestDispatcher("/WEB-INF/Views/front/index.jsp").forward(request, response);
         
        
        
        
        }catch(Exception e){
            out.println("<h1>" + e.getMessage()+ "</h1>");
        }
    }
    
    
    
}
