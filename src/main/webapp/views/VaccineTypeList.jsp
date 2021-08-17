<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>VaccineTypeList</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
	
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet"
	type="text/css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
	<script
	src="<%=request.getContextPath()%>/resources/vendors/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<h2 class="text-center">Vaccine Type List</h2>
	<div class="card mb-4">
		<div class="card-body">
			<form action="/cpl_java_03_vaccination_g1/VaccineTypeList"
				id="formVaccineTypeList">
				<table id="datatablesSimple" class="table table-striped">
					<thead class="thead-dark bg-success text-white">
						<tr>
							<th><input type="checkbox" name="boxbox"></th>
							<th>Code</th>
							<th>Vaccine Type Name</th>
							<th>Description</th>
							<th>Status</th>
							<th>Image</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th><input type="checkbox" name="boxbox"></th>
							<th>Code</th>
							<th>Vaccine Type Name</th>
							<th>Description</th>
							<th>Status</th>
							<th>Image</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${requestScope.vaccinetypes}" var="v">
							<tr>
								<td><input type="checkbox" name="vaccinetypebox"
									value="${v.id}"></td>
								<td><a href="#" class="update-vctype-link" value="${v.id}">${v.id}</a>
								</td>
								<td>${v.name}</td>
								<td>${v.description}</td>
								<td><c:choose>
										<c:when test="${fn:contains(v.status,'true') }">Active</c:when>
										<c:otherwise>Inactive</c:otherwise>
									</c:choose></td>
								<td><img alt="${v.name}"
									src="data:image/jpeg;base64,${v.base64imageFile}" width="40px"
									height="40px"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		

			<div>
				<input type="button" class="btn btn-primary"
					name="btnNewVaccineType" id="btnNewVaccineType"
					value="New Vaccine Type"> <input type="button"
					class="btn bg-warning text-white" disabled="disabled"
					name="btnMakeAcive" id="btnMakeInAciveVaccineType" value="Make In-Active">
			</div>
			</form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/datatables-simple-demo.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/js/index.js" type="text/javascript"></script>
	<script>
		var dataTable = new simpleDatatables.DataTable("#datatablesSimple", {

			perPage : 5

		});
	</script>
</body>

</html>