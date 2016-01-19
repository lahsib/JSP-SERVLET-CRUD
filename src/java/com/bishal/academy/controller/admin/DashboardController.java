/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.controller.admin;

import com.bishal.academy.service.CourseService;
import com.bishal.academy.service.impl.CourseServiceImpl;
import com.bishal.academy.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "dashboard" ,urlPatterns = {"/admin/"})
public class DashboardController extends Controller {
    CourseService courseService=new CourseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setHeader("Content-Type", "text/html");
        try{
            request.setAttribute("courses",courseService.getAll(true));
            request.getRequestDispatcher("/WEB-INF/Views/admin/index.jsp").forward(request, response);        
        }catch(Exception e){
            out.println("<h1>" + e.getMessage()+ "</h1>");
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
