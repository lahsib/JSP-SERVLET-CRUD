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
<h1>Edit Course</h1>
<form method="post" action="${SITE_URL}/c/update/">
    <div class="form-group">
        <label for="title">Course Name</label>
        <input type="hidden" class="form-control" name="id" id="id" required="required" value="${c.id}">
    </div>
    <div class="form-group">
        <label for="title">Course Name</label>
        <input type="text" class="form-control" name="name" id="name" required="required" value="${c.name}">
    </div>
    <div class="form-group">
        <label for="description">Course Description</label>
        <textarea name="description" class="form-control" rows="5" id="description" required="required">${c.description}</textarea>
    </div> 
    <div class="form-group">
        <label for="fees">Course Fees</label>
        <input type="text" class="form-control" name="fees" id="fees" required="required" value="${c.fees}">
    </div>
    <div class="form-group" col-sm>
        <label for="fees">Course Duration</label>
        <input type="text" class="form-control" name="duration" id="fees" required="required" value="${c.duration}">
    </div>
    <div class="form-group" col-sm>
        <label for="fees">Duration Type</label>
        <input type="text" class="form-control" name="durationtype" id="fees" required="required" value="${c.durationType}">
    </div>
     
    <div class="form-group">
        <label for="status">Status : </label>
        <input type="radio" id="status" name="status" value="1" <c:if test="${c.status}">checked="checked"</c:if>/>&nbsp;&nbsp;<label> Active </label>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" id="status" name="status" value="0" <c:if test="${!c.status}">checked="checked"</c:if>/>&nbsp;&nbsp;<label> Inactive </label>
    </div> 
    <button type="submit" class="btn btn-success" name="submit"><span class="glyphicon glyphicon-edit"> </span> Update Course</button>
</form>
<%@include file="../footer.jsp" %>