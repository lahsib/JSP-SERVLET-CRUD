/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishal.academy.controller.admin;

import com.bishal.academy.entity.Enquiry;
import com.bishal.academy.service.EnquiryService;
import com.bishal.academy.service.impl.EnquiryServiceImpl;
import com.bishal.academy.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet ( name = "enquiry", urlPatterns = {"/enquiry/*"})
public class EnquiryController extends Controller {
    private EnquiryService enquiryService = new EnquiryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getRequestURI().toLowerCase();
        PrintWriter out = response.getWriter();
        if(path.contains("/view")){
            try {
                request.setAttribute("enquiries",enquiryService.getAll(true));
                request.getRequestDispatcher("/WEB-INF/Views/admin/enquiry/index.jsp").forward(request, response);
            } catch (SQLException se) {
                out.println(se.getMessage());
            } catch (ClassNotFoundException ce) {
               out.println(ce.getMessage());
            }            
        }
        if(path.contains("/reply")){
            if(request.getParameter("id")!=null && !request.getParameter("id").isEmpty()){
                    try{
                    int id=Integer.parseInt(request.getParameter("id"));
                    Enquiry enquiry=enquiryService.getbyId(id);
                    
                    if(enquiry!=null){
                        request.setAttribute("e",enquiry);
                        request.getRequestDispatcher("/WEB-INF/Views/admin/enquiry/reply.jsp").forward(request, response);
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
        if(path.contains("/mail")){
            String email = request.getParameter("email");
            String msg = request.getParameter("message");
            
          String from = "lahsib.tmg@gmail.com";
          String host = "smtp.wlink.com.np";
          Properties properties = System.getProperties();
          properties.setProperty("mail.smtp.host", host);
          Session session = Session.getDefaultInstance(properties);

          try{
             MimeMessage message = new MimeMessage(session);
             message.setFrom(new InternetAddress(from));
             message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
             message.setSubject("Enrollment notice");
             message.setText(msg);
             Transport.send(message);
             out.println("success");
             out.println("Email Sent Successfully to " + email);
          }catch (Exception ex) {
            out.println(ex.getMessage());
      }
        }
    }

    
    
    
}
