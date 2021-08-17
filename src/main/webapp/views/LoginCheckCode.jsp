	<form action="/examples/actions/confirmation.php" method="post">
		<div class="form-group">
			<input type="text" class="form-control" id="code"
				placeholder="CODE" required="required">
							<input type="hidden" class="form-control" id="correct-code"
				value="${code}">
							<input type="hidden" class="form-control" id="email-login"
				value="${email}">
				<label id="err-code" style="color:red;"></label>
		</div>
		<div class="form-group">
			<button type="button" id="reset-pass" 
				class="btn btn-success btn-lg btn-block login-btn">Enter</button>
		</div>
	</form>
		<script type="text/javascript">
	$(document).ready(function() {
	$("#reset-pass").click(function() {
		var code = $('#code').val();
		var codeCorrect = $('#correct-code').val();
		var email=$('#email-login').val();
		if(code==codeCorrect){
			$.ajax({
				type: "POST",
				url: "/cpl_java_03_vaccination_g1/ForgotPasswordServletController?email="+email,
				success: function(responseData) {
					alert("New password sended to your email! Reset successful");
				},
				error: function() {

				}
			});
		}else{
			$("#err-code").text("Code not correct!!");
		}
	});
	});
	</script>