<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body class="sb-nav-fixed">
	<h2 class="mt-4 text-center">INJECTION SCHEDULE LIST</h2>
	<div class="card shadow mb-4">
		<div class="card-body">
			<table id="datatablesSimple" class="table table-striped">
				<thead class="thead-dark bg-success text-white">
					<tr>
						<th></th>
						<th>Vaccine</th>
						<th>Time</th>
						<th>Place</th>
						<th>Status</th>
						<th>Note</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th></th>
						<th>Vaccine</th>
						<th>Time</th>
						<th>Place</th>
						<th>Status</th>
						<th>Note</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach items="${requestScope.schedules}" var="schedule">
						<tr>
							<td><input type="radio" name="scheduleId"
								value="${schedule.id}" id="scheduleId"></td>
							<td><a href="#" class="update-sche-link"
								value="${schedule.id}">${schedule.vaccine.name}</a></td>
							<td>From ${schedule.timeBegin} to ${schedule.timeEnd}</td>
							<td>${schedule.place}</td>
							<td><c:if
									test="${schedule.vaccine.status eq true}">
                                                       Open
                                                   </c:if>
                                                   <c:if
									test="${schedule.vaccine.status eq false}">
                                                       Over
                                                   </c:if>
							</td>
							<td>${schedule.note}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="button" class="btn btn-primary"
				id="buttonScheduleCreate">New Inject Schedule</button>
			<button type="button" class="btn bg-warning text-white"
				id="buttonScheduleUpdate">Update Inject Schedule</button>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/index.js"
		type="text/javascript"></script>
</body>
