<%@page import="fa.appcode.web.entities.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Employee Management - Create Employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>

<style type="text/css">
.row {
	margin-bottom: 2rem;
}
</style>

</head>
<body class="sb-nav-fixed">
	<h2 class="mt-4 text-center">CREATE EMPLOYEE</h2>
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="col-lg-12 well">
				<div class="row">
					<form id="FormDetail"
						action="/cpl_java_03_vaccination_g1/EmployeeDetail"
						enctype="multipart/form-data">
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-4 form-group">
									<label>Employee id</label><label style="color: red;">(*)</label>:
									<br>
									<div class="d-flex">
										<input type="hidden" value="${action}" name="action">
										<i class="fas fa-id-card-alt"></i>&nbsp<input type="text"
											class="form-control" name="id"
											value="${requestScope.employee.id}" id="employeeId">
									</div>
									<div>
										<label style="color: red;">${messageID}</label>
									</div>
								</div>
								<div class="col-sm-4 form-group">
									<label>Employee name</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="fas fa-id-card-alt"></i>&nbsp<input type="text"
											class="form-control" name="name" required
											value="${requestScope.employee.name}">
									</div>
								</div>
								<div class="col-sm-4 form-group">
									<label>Gender</label>:<br> <i class="fas fa-venus-mars"></i><span>
									</span>
									<c:choose>
										<c:when
											test="${requestScope.employee.gender || empty requestScope.employee}">
											<input type="radio" id="male" name="gender" value="Male"
												checked>
											<label for="male"> Male </label>
											<input type="radio" id="female" name="gender" value="Female">
											<label for="female"> Female </label>
										</c:when>
										<c:otherwise>
											<input type="radio" id="male" name="gender" value="Male">
											<label for="male"> Male </label>
											<input type="radio" id="female" name="gender" value="Female"
												checked>
											<label for="female"> Female </label>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4 form-group">
									<label>Date of Birth</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="far fa-calendar-alt"></i>&nbsp<input type="date"
											class="form-control" name="dob" min="1956-01-01" max="2004-01-01" required
											value="${requestScope.employee.dob}">
									</div>
								</div>
								<div class="col-sm-4 form-group">
									<label>Phone</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="fas fa-phone-square-alt"></i>&nbsp<input type="tel"
											class="form-control" name="phone" required
											value="${requestScope.employee.phone}">
									</div>
									<div>
										<label id="message-phone" style="color: red;"></label>
									</div>
								</div>
								<div class="col-sm-4 form-group">
									<label>Address</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="fas fa-map-marker-alt"></i>&nbsp<input type="text"
											class="form-control" name="address" required
											value="${requestScope.employee.address}">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4 form-group">
									<label>Email</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="fas fa-envelope"></i>&nbsp<input type="email"
											class="form-control" name="email" required
											value="${requestScope.employee.email}">
									</div>
									<div>
										<label id="message-email" style="color: red;"></label>
									</div>
								</div>
								<div class="col-sm-4 form-group">
									<label>Working Place</label>:<br>
									<div class="d-flex">
										<i class="fas fa-university"></i>&nbsp<input type="text"
											name="workingPlace" class="form-control"
											value="${requestScope.employee.workingPlace}">
									</div>
								</div>
								<div class="col-sm-4 form-group">
									<label>Position</label>:<br>
									<div class="d-flex">
										<i class="fas fa-crosshairs"></i>&nbsp<input type="text"
											class="form-control" name="position"
											value="${requestScope.employee.position}">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4 form-group">
									<label for="img">Image</label>:<br>
									<div class="d-flex">
										<i class="fas fa-image"></i>&nbsp<input type="file" id="img"
											name="img" accept="image/*">
									</div>
									<div>
										<img alt="${requestScope.employee.name}" id="image"
											src="data:image/jpeg;base64,${requestScope.employee.base64imageFile}"
											width="160px" height="160px">
										<div>
											<input type="hidden" name="imageEncode"
												value="${requestScope.employee.base64imageFile}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div>
							<input type="submit" class="btn btn-primary" id="save-btn"
								value="Save"> <input type="reset"
								class="btn bg-warning text-white" value="Reset"> <input
								type="button" class="btn btn-danger" value="Cancel"
								id="cancel-btn">
						</div>
					</form>
				</div>
			</div>
			<br>
		</div>
	</div>
	<script type="text/javascript">
		document.getElementById("img").onchange = function() {
			var reader = new FileReader();

			reader.onload = function(e) {
				document.getElementById("image").src = e.target.result;
			};

			reader.readAsDataURL(this.files[0]);
		};
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/datatables-simple-demo.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/validateSchedule.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/index.js"
		type="text/javascript"></script>
</body>
</html>