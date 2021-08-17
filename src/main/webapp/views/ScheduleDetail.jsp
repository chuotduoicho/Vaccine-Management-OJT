<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <style>
.ck.ck-toolbar.ck-toolbar_grouping {
	width: 795px;
}
</style>
<body class="sb-nav-fixed">
	<h2 class="mt-4 text-center">CREATE INJECTION SCHEDULE</h2>
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="col-lg-12 well">
				<div class="row" style="margin-bottom: 2rem;">
					<form action="">
						<div class="col-sm-12">
							<div class="row" style="margin-bottom: 2rem;">
								<div class="col-sm-4 form-group">
									<input type="hidden" name="scheduleId"
										value="${requestScope.scheduleId}"> <label>Vaccine</label><label
										style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="fas fa-plus-square"></i>&nbsp <select
											name="vaccineId" id="vaccineId" class="form-control">
											<option value="${schedule.vaccine.id}" selected>${schedule.vaccine.name}</option>
											<c:forEach items="${requestScope.vaccines}" var="vaccine">
												<option value="${vaccine.id}">${vaccine.name}</option>
											</c:forEach>
										</select>
									</div>
										<div id="error-vaccine" style="color: red; margin-left: 5%;"></div>
								</div>
								<div class="col-sm-4 form-group">
									<label>From</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="far fa-calendar-alt"></i>&nbsp<span> </span><input
											type="text" class="form-control" id="from" name="from"
											value="${schedule.dateFrom}">
									</div>
									<div id="error-from" style="color: red; margin-left: 5%;"></div>
								</div>
								<div class="col-sm-4 form-group">
									<label>To</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="far fa-calendar-alt"></i>&nbsp<span> </span><input
											type="text" class="form-control" id="to" name="to"
											value="${schedule.dateTo}">
									</div>
									<div id="error-to" style="color: red; margin-left: 5%;"></div>
								</div>
							</div>
							<div class="row" style="margin-bottom: 2rem;">
								<div class="col-sm-4 form-group">
									<label>Place</label><label style="color: red;">(*)</label>:<br>
									<div class="d-flex">
										<i class="fas fa-university"></i>&nbsp<span> </span><input
											type="text" class="form-control" style="height: 100px;"
											id="place" value="${schedule.place}" name="place">
									</div>
									<div id="error-place" style="color: red; margin-left: 5%;"></div>
								</div>
								<div class="col-sm-4 form-group">
									<label>Note</label>:<br>
									<div class="d-flex">
										<i class="fas fa-bookmark"></i>&nbsp<span> </span>
										<div class="form-control" id="note"
											style="height: 100px; width: 220%;">${schedule.note}</div>
									</div>
							
								</div>
							</div>
						</div>
						<div style="">
							<input type="button" class="btn btn-primary" value="Save"
								id="Schedule-Update"> <input type="reset"
								class="btn bg-warning text-white" value="Reset"> <input
								type="button" class="btn btn-danger" value="Cancel"
								id="buttonScheduleCancel">
							
						</div>
					</form>
				</div>
			</div>
			<br>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/index.js"
		type="text/javascript"></script>
</body>
