<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="http://localhost:8080/cpl_java_03_vaccination_g1/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=request.getContextPath()%>/resources/vendors/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="Stylesheet" type="text/css" />
<script
	src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-success">
		<!-- Navbar Brand-->
		<a class="navbar-brand" style="margin-left: 0.5rem;" href="#"> <img
			src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/FPT_logo_2010.svg/800px-FPT_logo_2010.svg.png"
			width="60" height="30" class="d-inline-block align-top mx-auto"
			alt="">
		</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">

					<li><a class="dropdown-item"
						href="<%=request.getContextPath()%>/Login?action=logout">Logout</a></li>
				</ul></li>
		</ul>



	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav" id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="img bg-wrap py-4 text-center"
						style="background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWl415Yu10FRdxxxwkMwWFZXsSzAmgg_9bUw&amp;usqp=CAU); background-size: contain;">
						<div class="user-logo">
							<div class="img"
								style="background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ0RBJPFQMsKuUdAQaIiv3IChQx2ynXo_qKQ&amp;usqp=CAU); background-size: contain;"></div>
							<h5 class="text-white">${sessionScope.employee.name }</h5>
							<h6 class="text-white">${sessionScope.employee.email }</h6>
						</div>
					</div>
					<div class="nav">
						<a class="nav-link"
							href="http://localhost:8080/cpl_java_03_vaccination_g1/views/Dashboard.jsp">
							Home
							<div class="nav-link"></div>

						</a> <a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseEmployeeManagement"
							aria-expanded="false" aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							Employee Management
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseEmployeeManagement"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#" id="EmployeeList">Employee List</a>
								<a class="nav-link" href="#" id="EmployeeCreate">Create
									Employee</a>
							</nav>
						</div>
						<a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseCustomerManagement"
							aria-expanded="false" aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							Customer Management
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseCustomerManagement"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#">Customer List</a> <a
									class="nav-link" href="#">Create Customer</a>
							</nav>
						</div>
						<a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseVaccineTypeManagement"
							aria-expanded="false" aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							Vaccine Type Management
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseVaccineTypeManagement"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" id="VaccineTypeList" href="#">Vaccine
									Type List</a> <a class="nav-link" id="VaccineTypeCreate" href="#">Create
									Vaccine Type</a>
							</nav>
						</div>
						<a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseVaccineManagement" aria-expanded="false"
							aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							Vaccine Management
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseVaccineManagement"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#" id="VaccineList">Vaccine List</a> <a
									class="nav-link" href="#" id="VaccineCreate">Create Vaccine</a>
							</nav>
						</div>
						<a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseInjectionSchedule" aria-expanded="false"
							aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							Injection Schedule
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseInjectionSchedule"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#" id="ScheduleList">Injection
									Schedule List</a> <a class="nav-link" href="#" id="ScheduleCreate">Create
									Injection Schedule</a>
							</nav>
						</div>
						<a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseInjectionResult" aria-expanded="false"
							aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							Injection Result
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseInjectionResult"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#">Injection Result List</a> <a
									class="nav-link" href="#">Create Injection Result</a>
							</nav>
						</div>
						<a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseNews" aria-expanded="false"
							aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							News
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseNews"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#">News List</a> <a class="nav-link"
									href="#">Create News</a>
							</nav>
						</div>
						<a class="nav-link collapsed col-sm-12"
							style="padding-right: 0.1rem;" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseReport" aria-expanded="false"
							aria-controls="collapseLayouts"> <!--<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>-->
							Report
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseReport"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#">Reports List</a> <a
									class="nav-link" href="#">Reports Charts</a>
							</nav>
						</div>




					</div>
				</div>
				<!--                    <div class="sb-sidenav-footer">
                                            <div class="small">Logged in as:</div>
                                            Admin
                                        </div>-->
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4 mycontent">
					<h1 class="text-center">WELCOME TO VACCINE MANAGEMENT SYSTEM</h1>
					<div class="card mb-4">
						<div class="card-body"></div>
					</div>



				</div>
			</main>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"
		type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/index.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/datatables-simple-demo.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/validateVaccine.js"
		type="text/javascript"></script>
	<script>
		var dataTable = new simpleDatatables.DataTable("#datatablesSimple", {

			perPage : 5

		});
	</script>

</body>
</html>