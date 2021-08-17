<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1 class="text-center">IMPORT VACCINE</h1>
	<input type="hidden" id="VaccineAction" value="${action}">
	<div class="card mb-4">
		<div class="card-body shadow">
			<form>
				<div class="col-sm-12">
					<div class="row" style="padding-bottom: 20px">
						<div class="col-sm-12 form-group">
							<label>Import file</label>:<br>
							<input type="file" class="form-control" id="vaccine-file" accept=".xlsx">
						</div>
					</div>
				</div>
				<div>
					<input type="button" class="btn btn-primary" id="btn-vaccine-import"
						value="Import"> <input type="reset"
						class="btn bg-warning text-white" id="buttonVaccineReset"
						value="Reset"> <input type="button" class="btn btn-danger"
						id="buttonVaccineCancel" value="Cancel">
					<div id="error" style="color: red; margin-left: 35%;">${error}</div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"
		type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/datatables-simple-demo.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/js/index.js"
		type="text/javascript"></script>
</body>
</html>