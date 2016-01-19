<%@include file="../header.jsp" %>

<h1>${course.name}</h1>
<div class="list-group">
    <ul>
        <li>${course.description}</li>
        <li>Fees:${course.fees}</li>
    </ul>
</div>
<a class="btn btn-primary" href="${SITE_URL}/enroll/?cid=${course.id}">Enroll Now</a></button>
</p>
<%@include file="../footer.jsp" %>