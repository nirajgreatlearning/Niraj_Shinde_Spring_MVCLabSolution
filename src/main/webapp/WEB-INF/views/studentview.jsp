<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="jumbotron">
		<h1>Edit Student</h1>
		Web Application Context Path = ${pageContext.request.contextPath}
	</div>
	<form:form method="POST" action="/StudentManagement/save"
		modelAttribute="studentInfo">
		<form:hidden path="id" />
		<div class="mb-3 row">
			<c:set var="firstNameHasBindError">
				<form:errors path="firstName" />
			</c:set>
			<label for="firstName" class="col-sm-2 col-form-label">First
				Name:</label>
			<div class="col-sm-4">
				<form:input
					class="form-control ${not empty firstNameHasBindError?'is-invalid':''}"
					path="firstName" />
				<div id="firstName" class="invalid-feedback">
					${firstNameHasBindError}</div>
			</div>
		</div>
		<div class="mb-3 row">
			<c:set var="lastNameHasBindError">
				<form:errors path="lastName" />
			</c:set>
			<label for="lastName" class="col-sm-2 col-form-label">Last
				Name:</label>
			<div class="col-sm-4">
				<form:input
					class="form-control ${not empty lastNameHasBindError?'is-invalid':''}"
					path="lastName" />
				<div id="firstName" class="invalid-feedback">
					${lastNameHasBindError}</div>
			</div>
		</div>
		<div class="mb-3 row">
			<c:set var="courseNameHasBindError">
				<form:errors path="courseName" />
			</c:set>
			<label for="courseName" class="col-sm-2 col-form-label">Course
				Name:</label>
			<div class="col-sm-4">
				<form:input
					class="form-control ${not empty courseNameHasBindError?'is-invalid':''}"
					path="courseName" />
				<div id="firstName" class="invalid-feedback">
					${courseNameHasBindError}</div>
			</div>
		</div>
		<div class="mb-3 row">
			<c:set var="countryNameHasBindError">
				<form:errors path="countryName" />
			</c:set>
			<label for="countryName" class="col-sm-2 col-form-label">Country
				Name:</label>
			<div class="col-sm-4">
				<form:input
					class="form-control ${not empty countryNameHasBindError?'is-invalid':''}"
					path="countryName" />
				<div id="firstName" class="invalid-feedback">
					${countryNameHasBindError}</div>
			</div>
		</div>
		<div class="mb-3 row">
			<label class="col-sm-2 col-form-label"></label>
			<div class="col-sm-4">
				<input type="submit" style="float: right;"
					class="btn btn-sm btn-primary" value="Update Student" />
			</div>
		</div>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
