<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>VaccineTypeCreate</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
	<style>
.ck.ck-toolbar.ck-toolbar_grouping {
	width: 1000px;
}
.row {
	margin-bottom: 2rem;
}
</style>
</head>

<body>
	<h1 class="text-center">Create Vaccine Type</h1>
	<div class="card mb-4">
		<div class="card-body">
			<form id="formVaccineTypeDetail"
				action="/cpl_java_03_vaccination_g1/VaccineTypeDetail"
				enctype="multipart/form-data">
				<div class="col-lg-12 well">
					<div class="row">

						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-4 form-group">
									<label>Vaccine Type Code</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<input
											type="text" class="form-control" name="id" id="vaccinetypeid"
											value="${vaccinetype.id}" required>
									</div>
									<div>
											<label id="message-id" style="color: red;">${messageID}</label>
										</div>
								</div>
								<div class="col-sm-6 form-group">
									<label>Vaccine Type Name</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<input
											type="text" class="form-control" name="name" id="name"
											value="${vaccinetype.name}" required>
									</div>
								</div>
								<div class="col-sm-2 form-group">
									<label>Active</label><label style="color: red;">(*)</label>:<br>
										<input class="form-check-input" type="checkbox"
										name="status" id="vaccinetypestatus" disabled="disabled"
										  value="active" style="margin-top: 10px;"
										${vaccinetype.status? "checked": "" }>

								</div>
							</div>
							<div class="row">
								<div>
									<label class="col-sm-12 form-group">Description<label style="color: red">(*)</label>:
									</label><br>
									<div class="d-flex">
										<div class="form-control" id="note"
											style="height: 100px; width: 208%;">${vaccinetype.description}</div>
									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-sm-12 form-group">
									<label for="img">Image</label>:<br> <i
										class="fas fa-image"></i><span> </span><input type="file"
										id="img" name="img" accept="image/*">
								</div>
							</div>
						</div>
						<div>
							<input type="submit" class="btn btn-primary" id="VaccineTypeSave"
								value="Save"> <input type="reset"
								class="btn bg-warning text-white" id="VaccineTypeReset"
								value="Reset"> <input type="button"
								class="btn btn-danger" id="VaccineTypeCancel" value="Cancel">
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
</body>

</html>