<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Vaccine -Vaccine List</title>
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
.dataTable-dropdown>label {
	width: 160%;
}

.dataTable-selector {
	width: 25%;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h2 class="mt-4 text-center">VACCINE LIST</h2>
	<div class="card shadow mb-4">
		<div class="card-body">
			<form action="/cpl_java_03_vaccination_g1/ListVaccine" id="FormVList">
				<table id="datatablesSimple" class="table table-striped">
					<thead class="thead-dark bg-success text-white">
						<tr>
							<th><input type="checkbox" name="" id=""></th>
							<th>Vaccine id</th>
							<th>Vaccine name</th>
							<th>Vaccine type</th>
							<th>Number of injection</th>
							<th>Origin</th>
							<th>Status</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th><input type="checkbox" name="" id=""></th>
							<th>Vaccine id</th>
							<th>Vaccine name</th>
							<th>Vaccine type</th>
							<th>Number of injection</th>
							<th>Origin</th>
							<th>Status</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${requestScope.vaccineVos}" var="vo">
							<tr>
								<td><input type="checkbox" name="vaccine"
									value="${vo.vaccineId}"></td>
								<td><a href="#" class="update-vaccine-link"
									value="${vo.vaccineId}">${vo.vaccineId}</a></td>
								<td>${vo.vaccineName}</td>
								<td>${vo.vaccineTypeName}</td>
								<td>${vo.numberOfInjection}</td>
								<td>${vo.origin}</td>
								<td>${(vo.status)?"Active":"Inactive"}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<button type="button" class="btn btn-primary" id="btnNewVaccine">New
						Vaccine</button>
					<button type="button" class="btn bg-warning text-white"
						id="btnUpdateVaccine" disabled="disabled">Update Vaccine</button>
					<button type="submit" class="btn btn-danger" id="btnMakeInactiveVaccine"
						disabled="disabled">Make In-Active</button>
					<button type="button" class="btn btn-secondary" id="btnImportVaccine" >Import Vaccine</button>
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