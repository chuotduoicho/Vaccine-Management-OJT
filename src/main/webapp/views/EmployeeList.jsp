<%@page import="fa.appcode.common.logging.Logging"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Employee Management - Employee List</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<style type="text/css">
a {
	text-decoration: none;
}

.dataTable-dropdown>label {
	width: 160%;
}

.dataTable-selector {
	width: 25%;
}
</style>
</head>
<body>
	<h2 class="mt-4 text-center">EMPLOYEE LIST</h2>
	<div class="card shadow mb-4">
		<div class="card-body">
			<form>
				<table id="datatablesSimple" class="table table-striped">
					<thead class="thead-dark bg-success text-white">
						<tr>
							<th><input type="checkbox" name="emps" id=""></th>
							<th>Employee ID</th>
							<th>Employee name</th>
							<th>Date of Birth</th>
							<th>Gender</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Image</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th><input type="checkbox" name="emps" id=""></th>
							<th>Employee ID</th>
							<th>Employee name</th>
							<th>Date of Birth</th>
							<th>Gender</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Image</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${requestScope.employees}" var="employee">
							<tr>
								<td><input type="checkbox" name="emp"
									value="${employee.id}"></td>
								<td><a href="#" class="update-emp-link"
									value="${employee.id}">${employee.id}</a></td>
								<td>${employee.name}</td>
								<td>${employee.dob}</td>
								<td><c:choose>
										<c:when test="${employee.gender}">Male</c:when>
										<c:otherwise>Female</c:otherwise>
									</c:choose></td>
								<td>${employee.phone}</td>
								<td>${employee.address}</td>
								<td><img alt="${employee.name}"
									src="data:image/jpeg;base64,${employee.base64imageFile}"
									width="40px" height="40px"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<button type="button" class="btn btn-primary" id="new-emp-btn">New
						Employee</button>
					<button type="button" class="btn bg-warning text-white"
						id="upd-emp-btn" disabled="disabled">Update Employee</button>
					<button type="button" class="btn btn-danger" id="del-emp-btn"
						disabled="disabled">Delete Employee</button>
				</div>
			</form>
		</div>
	</div>
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
	<script>
		var dataTable = new simpleDatatables.DataTable("#datatablesSimple", {

			perPage : 5

		});
	</script>
</body>
</html>
