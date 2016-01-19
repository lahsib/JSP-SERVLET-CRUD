<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>

    <div class="container">
  <h1>Courses <small>Add,Edit & Delete here</small></h1>
  <div class="pull-right">
     <a href="${SITE_URL}/c/add" class="btn btn-primary"> <span class="glyphicon glyphicon-plus"></span> Add New</a>
  </div>
  <h3>${param.message}</h3>
  <c:remove var="message" scope="session" /> 
  <br><br>
    <table class="table table-bordered table-striped table-hover">
    <tr>
        <th>Id</th>
        <th>Course Name</th>
        <th>Description</th>
        <th>Fees</th>
        <th>Duration</th>
        <th>Duration Type</th>         
        <th>Added Date</th>
        <th>Modified Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="c" items="${requestScope.courses}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>${c.fees}</td>
            <td>${c.duration}</td>
            <td>${c.durationType}</td>
            
            <td>${c.addedDate}</td>
           <td>${c.modifiedDate}</td>
            <td>${c.status}</td>
            <td>
                <a href="${SITE_URL}/c/edit/?id=${c.id}" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-pencil"></span></a>
                <a href="${c.id}" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>
            </td>
            
        </tr>
    </c:forEach>
    </table>
</div>
<%@include file="footer.jsp" %>