<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
	<style type="text/css">
		.error-message{
			color:red;
		}
	</style>
</head>
<body>
	<h1 class="text-center">CREATE VACCINE</h1>
	<input type="hidden" id="VaccineAction" value="${action}">
	<div class="card mb-4">
		<div class="card-body shadow">
			<form>
				<div class="col-sm-12">
					<div class="row" style="padding-bottom: 20px">
						<div class="col-sm-8 form-group">
							<label>Vaccine Id</label><label style="color: red;">(*)</label>:<br>
							<input type="text" name="id" class="form-control" id="vaccineId"
								${action == 'update'?"readonly":"" } required
								value="${vaccine.id }">
								<div><label class="error-message" id="error-id">${error}</label></div>
						</div>

						<div class="col-sm-4 form-group">
							<label>Active</label><label style="color: red;">(*)</label>:<br>
							<i class="fas fa-fill-drip"></i><span> </span> <input
								class="form-check-input" name="status" type="checkbox"
								id="status" ${action == 'create'?"disabled":""}
								style="margin-left: 20px;"
								${vaccine.status || action == 'create' ?"checked":"" }>

						</div>
					</div>
					<div class="row" style="padding-bottom: 30px">
						<div class="col-sm-4 form-group">
							<label>Vaccine Name</label><label style="color: red;">(*)</label>:<br>
							<input type="text" name="name" class="form-control" id="name"
								required value="${vaccine.name }">
								<div><label class="error-message" id="error-name"></label></div>
						</div>
						<div class="col-sm-4 form-group">
							<label>Vaccine Type</label><label style="color: red;">(*)</label>:<br>
							<select name="type" id="vaccineTypeSelect" class="form-control">
								<c:if test="${action == 'update'}">
									<option value="${vaccine.type.id }" selected>${vaccine.type.name}</option>
								</c:if>
								<option value="-1">- Select Vaccine Type</option>
								<c:forEach items="${requestScope.types}" var="type">
									<option value="${type.id}">${type.name}</option>
								</c:forEach>
							</select>
							<div><label class="error-message" id="error-type"></label></div>
						</div>
						<div class="col-sm-4 form-group">
							<label>Number of Inject:</label><br> </i><input type="text"
								name="numberInject" class="form-control" id="numberInject"
								value="${vaccine.numberOfInject }">
						</div>
					</div>
					<div class="row" style="padding-bottom: 30px">
						<div class="col-sm-4 form-group">
							<label>Usage:</label><br>
							<textarea class="form-control" name="usage" rows="3" id="usage">${vaccine.useage }</textarea>
						</div>
						<div class="col-sm-4 form-group">
							<label>Indication:</label><br>
							<textarea class="form-control" name="indication" rows="3"
								id="indication">${vaccine.indication }</textarea>
						</div>
						<div class="col-sm-4 form-group">
							<label>Contraindication:</label><br>
							<textarea class="form-control" name="contraindication" rows="3"
								id="contraindication">${vaccine.contraindication }</textarea>
						</div>
					</div>

					<div class="row" style="padding-bottom: 30px">
						<div class="col-sm-4 form-group">
							<label>Time of beginning next injection:</label><br> <input
								type="date" class="form-control" name="begin" id="begin"
								value="${vaccine.timeBegin }">
						</div>
						<div class="col-sm-4 form-group">
							<label>Time of ending next injection:</label><br> <input
								type="date" class="form-control" name="end" id="end"
								value="${vaccine.timeEnd }">
								<div><label class="error-message" id="error-end"></label></div>
						</div>
						<div class="col-sm-4 form-group">
							<label>Origin:</label><br> <input type="text"
								class="form-control" name="origin" id="origin"
								value="${vaccine.origin }">
						</div>
					</div>
				</div>
				<div>
					<input type="button" class="btn btn-primary" id="buttonVaccineSave"
						value="Save"> <input type="reset"
						class="btn bg-warning text-white" id="buttonVaccineReset"
						value="Reset"> <input type="button" class="btn btn-danger"
						id="buttonVaccineCancel" value="Cancel">
					<div id="error" style="color: red; margin-left: 35%;">${error}</div>
				</div>
			</form>
		</div>
	</div>
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