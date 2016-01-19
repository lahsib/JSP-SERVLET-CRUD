<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>   
<h1>Bishal Academy</h1><hr><hr>
<ul class="nav nav-pills">
  <c:forEach var="course" items="${requestScope.courses}">
  <li role="presentation" class="active"><a href="${SITE_URL}/course/detail/?id=${course.id}">${course.name}</a></li>
  </c:forEach>
  
</ul>
<%@include file="footer.jsp" %>
