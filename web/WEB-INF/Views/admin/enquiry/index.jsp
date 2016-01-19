<%@include  file="../header.jsp" %>
<%@include  file="../navbar.jsp" %>
<div class="container">
    <h1>Enquiries</h1>
<table class="table table-bordered table-striped table-hover">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact No.</th>
        <th>course</th>
        <th> Message</th>         
        <th>Enquiry Date</th>
        <th>Is Read</th>
        <th>Parent id</th>
        <th>Action</th>
        <th>Replay</th>
    </tr>
    <c:forEach var="e" items="${requestScope.enquiries}">
        <tr>
            <td>${e.id}</td>
            <td>${e.firstName} ${e.lastName} </td>
            <td>${e.email}</td>
            <td>${e.contactNo}</td>
            <td>${e.course.id}</td>
            <td>${e.message}</td>
            
            <td>${e.enquiryDate}</td>
           <td>${e.isRead}</td>
            <td>${e.parentId}</td>
            <td>
                <a href="#" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-pencil"></span></a>
                <a href="#" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>
            </td>
            <td><a href="${SITE_URL}/enquiry/reply/?id=${e.id}" class="btn btn-primary btn-sm">Replay</a>
                <a href="${SITE_URL}/enquiry/reply" class="btn btn-primary btn-sm">View Replay</a></td>

        </tr>
    </c:forEach>
    </table>    
</div>

<%@include  file="../footer.jsp" %>