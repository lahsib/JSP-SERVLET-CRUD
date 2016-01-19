<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp"%>
<%@include file="../navbar.jsp"%>
<div class="container">
    <h3>Send Email <small> replay to the enrolled student</small></h3>
    <form method="post" action="${SITE_URL}/enquiry/mail/">
        <div class="form-group">
            <label>Email</label>
           
            <input type="email" name="email" class="form-control" value="${e.email}">
            
        </div>
        <div class="form-group">
            <label>Message</label>
            
            <textarea class="form-control" name="message"></textarea>
            
        </div>
        <button class="btn btn-success" type="submit">Send Mail</button>
    </form>    
</div>
<%@include file="../footer.jsp"%>