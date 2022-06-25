<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="jumbotron">
		<h1>Students</h1>
	</div>
	<a href="add" class="btn btn-info">Register new student</a> <br> <br>
	<c:if test="${students.size() > 0}">
		<table class="table">
			<thead>
				<tr>
					<th>Student Id</th>
					<th>Name</th>
					<th>Course</th>
					<th>Country</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.id}" /></td>
					<td><c:out value="${student.firstName}" /></td>
					<td><c:out value="${student.courseName}" /></td>
					<td><c:out value="${student.countryName}" /></td>
					<td><a class="btn btn-sm btn-primary"
						href="view/${student.id}">Modify</a></td>
					<td><a class="btn btn-sm btn-danger"
						href="deletestudent/${student.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
</div>

</c:if>
<%@ include file="common/footer.jspf"%>