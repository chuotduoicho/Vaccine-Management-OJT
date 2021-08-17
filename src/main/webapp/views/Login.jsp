<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link
	href="http://localhost:8080/cpl_java_03_vaccination_g1/resources/css/styles.css"
	rel="stylesheet" type="text/css" />
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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/vendors/bootstrap/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/vendors/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 	<script>
$(document).ready(function(){
  $("#link-forgot").click(function(){
    $("#login").fadeOut();
    $("#forgot-password").fadeIn();
  });
});
</script> -->
<style>
body {
	font-family: 'Varela Round', sans-serif;
}

.modal-login {
	color: #636363;
	width: 350px;
}

.modal-login .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
}

.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-login h4 {
	text-align: center;
	font-size: 26px;
	margin: 30px 0 -15px;
}

.modal-login .form-control:focus {
	border-color: #70c5c0;
}

.modal-login .form-control, .modal-login .btn {
	min-height: 40px;
	border-radius: 3px;
}

.modal-login .close {
	position: absolute;
	top: -5px;
	right: -5px;
}

.modal-login .modal-footer {
	background: #ecf0f1;
	border-color: #dee4e7;
	text-align: center;
	justify-content: center;
	margin: 0 -20px -20px;
	border-radius: 5px;
	font-size: 13px;
}

.modal-login .modal-footer a {
	color: #999;
}

.modal-login .avatar {
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -70px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	background: #60c7c1;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.modal-login .avatar img {
	width: 100%;
}


.modal-login .avatar {
	background: #198754;
}

.modal-login.modal-dialog {
	margin-top: 80px;
}

.modal-login .btn, .modal-login .btn:active {
	color: #fff;
	border-radius: 4px;
	background: #5dcc75 !important;
	text-decoration: none;
	transition: all 0.4s;
	line-height: normal;
	border: none;
}

.modal-login .btn:hover, .modal-login .btn:focus {
	background: #298434 !important;
	outline: none;
}
</style>
</head>
<body>
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-success">
		<!-- Navbar Brand-->
		<a class="navbar-brand" style="margin-left: 0.5rem;" href="#"> <img
			src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/FPT_logo_2010.svg/800px-FPT_logo_2010.svg.png"
			width="60" height="30" class="d-inline-block align-top mx-auto"
			alt="">
		</a>
		<ul class="navbar-nav ms-auto me-0 me-md-3 my-2 my-md-0">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">

					<li><a class="dropdown-item" data-toggle="modal" data-target="#login" href="#">Login</a></li>
				</ul></li>
		</ul>

	</nav>
<!-- 	<div id="login" class="modal fade">
		<div class="modal-dialog modal-login">
			<div class="modal-content">
				<div class="modal-header">
					<div class="avatar">
						<img
							src="https://www.tutorialrepublic.com/examples/images/avatar.png"
							alt="Avatar">

	</nav>
					</div>
					<h4 class="modal-title">Member Login</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>

				</div>
				<div class="alert alert-danger text-center">
				Login failed! Incorrect username or password!
			</div>
				<div class="modal-body">
					<form action="/examples/actions/confirmation.php" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="username"
								placeholder="Username" required="required">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required="required">
						</div>
						<div class="form-group">
							<button type="submit"
								class="btn btn-primary btn-lg btn-block login-btn">Login</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<a href="#">Forgot Password?</a> -->
	<div id="login" class="modal fade" >
		<div class="modal-dialog modal-login">
			<div class="modal-content" style="margin-top=50px;">
				<div class="modal-header">
					<div class="avatar">
						<img
							src="https://www.tutorialrepublic.com/examples/images/avatar.png"
							alt="Avatar">
					</div>
					<h4 class="modal-title">Member Login</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>

				</div>
				<div class="modal-body">
					<c:if test="${not empty message}">
						<div class="alert alert-warning">${message}</div>
					</c:if>
					<form action="/cpl_java_03_vaccination_g1/Login" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="username"
								placeholder="Username" required="required">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required="required">
						</div>
						<div class="form-group">
							<button type="submit"
								class="btn btn-success btn-lg btn-block login-btn">Login</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<a data-toggle="modal" data-target="#forgot-password"  href="#">Forgot Password?</a>
				</div>
			</div>
		</div>
	</div>
	<div id="forgot-password" class="modal fade" >
		<div class="modal-dialog modal-login">
			<div class="modal-content" style="margin-top=50px;">
				<div class="modal-header">
					<div class="avatar">
						<img
							src="https://www.tutorialrepublic.com/examples/images/avatar.png"
							alt="Avatar">
					</div>
					<h4 class="modal-title">Forgot Password</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>

				</div>
				<div class="modal-body">
					<form action="/examples/actions/confirmation.php" method="post">
						<div class="form-group">
							<input type="email" class="form-control" id="email-verify"
								placeholder="Email" required="required">
						</div>
						<div class="form-group">
							<button type="button" id="reset-password"  data-toggle="modal" data-target="#check-code"data-dismiss="modal" 
								class="btn btn-success btn-lg btn-block login-btn">Reset Password</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<a data-toggle="modal" data-dismiss="modal" href="#">Return to login</a>
				</div>
			</div>
		</div>
	</div>
	<div id="check-code" class="modal fade" >
		<div class="modal-dialog modal-login">
			<div class="modal-content" style="margin-top=50px;">
				<div class="modal-header">
					<div class="avatar">
						<img
							src="https://www.tutorialrepublic.com/examples/images/avatar.png"
							alt="Avatar">
					</div>
					<h4 class="modal-title">CHECK CODE</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>

				</div>
				<div class="modal-body" id="form-checkcode">
	
				</div>
				<div class="modal-footer">
					<a data-toggle="modal" data-dismiss="modal" href="#">Return to verify email</a>
				</div>
			</div>
		</div>
	</div>
	<div id="success" class="modal fade" >
	
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/js/index.js"
		type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#reset-password").click(function() {
			var mail = $('#email-verify').val();
			$.ajax({
				url: "/cpl_java_03_vaccination_g1/ForgotPasswordServletController?mail="+mail,
				success: function(responseData) {
					$("#forgot-password").modal('hide');
					$("#form-checkcode").html(responseData);
				},
				error: function() {

				}
			});
		});
	});
	$(window).on('load', function() {
        $('#login').modal('show');
    });
	</script>
</body>
</html>