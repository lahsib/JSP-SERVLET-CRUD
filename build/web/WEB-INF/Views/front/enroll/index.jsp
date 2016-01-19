<%@include file="../header.jsp" %>
<h1>Enrollment Form</h1><hr><hr>
 <div class="content">
 <div class="row col-lg-4">
<form action="${SITE_URL}/enroll" method="post" role="form">
   
    <div class="form-group">
    <label>First Name</label>
    <input type="text" name="first_name" class="form-control"/>
    </div>
    <div class="form-group">
    <label>Last Name</label>
    <input type="text" name="last_name" class="form-control"/>
    </div>
    <div class="form-group">
    <label>Email</label>
    <input type="email" name="email" class="form-control"/>
    </div>    
    <div class="form-group">
    <label>Contact No</label>
    <input type="text" name="contact_no" class="form-control"/>
    </div> 
    <div class="form-group" >
    <label>Course</label>
    <select name="course" class="form-control">
        <option value="">Select Course</option>
    <c:forEach var="course" items="${requestScope.courses}">
        <option value="${course.id}" <c:if test="${param.cid == course.id}">selected="selected"</c:if>>
            ${course.name}
        </option>
        
    </c:forEach>
    </select>
    </div>
    <br>
    <div class="form-group">
    <label>Message</label>
    <textarea name="message" style="height:150px" class="form-control"></textarea>
    </div>
    <button type="submit" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-education"></span> Enroll Now</button>
</form>
</div>
 </div>
<%@include file="../footer.jsp" %>