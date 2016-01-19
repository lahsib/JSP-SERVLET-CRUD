<%-- 
    Document   : add
    Created on : Dec 5, 2015, 9:16:53 AM
    Author     : Bishal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%@include file="../navbar.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<h1>Add New Course</h1>
<form method="post" action="${SITE_URL}/c/save">
    <div class="form-group">
        <label for="title">Course Name</label>
        <input type="text" class="form-control" name="name" id="name" required="required">
    </div>
    <div class="form-group">
        <label for="description">Course Description</label>
        <textarea name="description" class="form-control" rows="5" id="description" required="required"></textarea>
    </div> 
    <div class="form-group">
        <label for="fees">Course Fees</label>
        <input type="text" class="form-control" name="fees" id="fees" required="required">
    </div>
    <div class="form-group">
        <label for="duration">Duration</label>
        <select class="form-group" name="duration">
            <c:forEach var="duration" begin="1" end="30" step="1">
                <option>${duration}</option>
            </c:forEach>
        </select>&nbsp;&nbsp;&nbsp;
        <label for="duration">Duration Type</label>
        <select class="form-group" name="durationtype">
                <option>Days</option>
                <option>Week</option>
                <option>Month</option>
                <option>Year</option>
        </select>
    </div>  
     
    <div class="form-group">
        <label for="status">Status : </label>
        <input type="radio" id="status" name="status" value="1" aria-label="...">&nbsp;&nbsp;<label> Active </label>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" id="status" name="status" value="0" aria-label="...">&nbsp;&nbsp;<label> Inactive </label>
    </div> 
    <button type="submit" class="btn btn-success" name="submit"><span class="glyphicon glyphicon-floppy-save"> </span> Save Course</button>
</form>
<%@include file="../footer.jsp" %>