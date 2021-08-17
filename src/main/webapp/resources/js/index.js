/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
	$("#VaccineTypeList").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineTypeList",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				//alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#VaccineTypeCreate").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineTypeCreate",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				$("#vaccinetypestatus").prop("checked", true);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#btnNewVaccineType").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineTypeCreate",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				$("#vaccinetypestatus").prop("checked", true);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#VaccineTypeCancel").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineTypeList",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("body").on("click", "a.update-vctype-link", function() {
		let id = $(this).attr("value");
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineTypeDetail",
			data: {
				id: id
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
				$("#vaccinetypeid").attr("readonly", true);
				$("#vaccinetypestatus").prop("disabled", false);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	function validateId(id) {
		let regex = /[a-zA-Z0-9]+[\/\_]{1}[a-zA-Z0-9]+/;
		return regex.test(id);
	}

	$("#formVaccineTypeDetail").submit(function(e) {
		e.preventDefault();// avoid submit event in jsp form
		let formData = new FormData(this);
		let id = $('input[name="id"]').val();
		let name = $('input[name="name"]').val();
		let status = $('input[name="status"]').is(":checked");
		let description = $(".ck.ck-content.ck-editor__editable.ck-rounded-corners.ck-editor__editable_inline.ck-blurred").html();
		let img = $('input[name="img"]').val();
		let check = true;

		if (!validateId(id)) {
			$("#message-id").html("Input ID not follow the format!!! (Format: abc_123 OR abc/123 )");
			check = false;
		}

		if (check == false) {
			return false;
		} else {
			formData.append('id', id);
			formData.append('name', name);
			formData.append('status', status);
			formData.append('description', description);
			formData.append('img', img);

			$.ajax({
				url: $(this).attr("action"),
				enctype: 'multipart/form-data',
				type: "post",
				data: formData,
				success: function(responseData) {
					$(".mycontent").html(responseData);
					// alert(formData);
				},
				error: function() {

				},
				processData: false,
				contentType: false
			});

		}
	});

	$("#formVaccineTypeList").submit(function(e) {
		e.preventDefault();
		let checkedInActive = [];

		$("input[name='vaccinetypebox']:checked").each(function() {
			checkedInActive.push($(this).val());
		});

		$.ajax({
			url: $(this).attr("action"),
			type: "post",
			data: {
				vaccinetypebox: checkedInActive
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
			},
			error: function() {

			},
		});
	});
	
	$("#btnMakeInAciveVaccineType").on('click', function() {
		let checkedInactiveVaccineType = [];

		$("input[name='vaccinetypebox']:checked").each(function() {
			checkedInactiveVaccineType.push($(this).val());
		});

		$.confirm({
			title: 'Confirm',
			content: `<i class="fas fa-info-circle" style="color: green;"></i> ` + 'Are you sure to make inactive?',
			buttons: {
				OK: function() {
					$.ajax({
						url: "/cpl_java_03_vaccination_g1/VaccineTypeList",
						type: "post",
						data: {
							vaccinetypebox: checkedInactiveVaccineType
						},
						success: function(responseData) {
							$(".mycontent").html(responseData);
						},
						error: function() {

						},
					});
				},
				Cancel: function() {
					
				},
			}
		});
	});



	//tai 
	$("#ScheduleList").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ScheduleListServletController",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				 //alert(responseData);
			},
			error: function() {

			}
		});
	});
	$("#ScheduleCreate").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ScheduleUpdateServletController?scheduleId=0",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});
	$("#buttonScheduleCreate").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ScheduleUpdateServletController?scheduleId=0",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});
	$("#buttonScheduleUpdate").click(function() {
		var scheduleId = $('input[name="scheduleId"]:checked').val();
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ScheduleUpdateServletController",
			data: {
				scheduleId: scheduleId
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});
	$("body").on("click", "a.update-sche-link", function() {
		var scheduleId = $(this).attr("value");
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ScheduleUpdateServletController",
			data: {
				scheduleId: scheduleId
			},
			success: function(responseData) {
				$("employeeId").attr("readonly", true);
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#buttonScheduleReset").click(function() {
		document.getElementById("to").value = "";
		document.getElementById("from").value = "";
		document.getElementById("note").value = "";
		document.getElementById("place").value = "";
	});
	$("#buttonScheduleCancel").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ScheduleListServletController",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	function setBorderColor(element) {
		if (element.val() == "" || element.val() == "-1") {
			element.attr("style", "border-color:red");
		} else {
			element.attr("style", "border-color:#ced4da");
		}
	}

	$("#Schedule-Update").click(function() {
		var scheduleId = $('input[name="scheduleId"]');
		var vaccineId = $('#vaccineId');
		var from = $('#from');
		var to = $('#to');
		var place = $('#place');
		var note = $(".ck.ck-content.ck-editor__editable.ck-rounded-corners.ck-editor__editable_inline.ck-blurred");
		setBorderColor(vaccineId);
		setBorderColor(from);
		setBorderColor(to);
		setBorderColor(place);
		if (place.val() == "") {
			$('#error-place').text("-Field (*) must be not empty");
		} else {
			$('#error-place').text("");
		}
		if (from.val() == "") {
			$('#error-from').text("-Field (*) must be not empty");
		} else {
			$('#error-from').text("");
		}
		if (to.val() == "") {
			$('#error-to').text("-Field (*) must be not empty");
		} else {
			$('#error-to').text("");
		}
		if (vaccineId.val() == "-1" || vaccineId.val() == "") {
			$('#error-vaccine').text("-Field (*) must be not empty");
		} else {
			$('#error-vaccine').text("");
		}
		if (place.val() == "" || from.val() == "" || to.val() == "" || vaccineId.val() == "-1" || vaccineId.val() == "") {

		} else {
			alert("Update successfull !!");
			$.ajax({
				type: "POST",
				url: "/cpl_java_03_vaccination_g1/ScheduleUpdateServletController",
				data: {
					scheduleId: scheduleId.val(),
					vaccineId: vaccineId.val(),
					from: from.val(),
					to: to.val(),
					place: place.val(),
					note: note.html()
				},
				success: function(responseData) {
					$(".mycontent").html(responseData);
					// alert(responseData);
				},
				error: function() {

				}
			});
		}
	});
	//tai 


	$("#EmployeeList").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/EmployeeList",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {


			}
		});
	});

	$("#cancel-btn").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/EmployeeList",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#EmployeeCreate").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/EmployeeCreate?action=create",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#new-emp-btn").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/EmployeeCreate?action=create",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("body").on("click", "a.update-emp-link", function() {
		var id = $(this).attr("value");
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/EmployeeDetail?action=update",
			data: {
				id: id
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
				$("#employeeId").attr('readonly', true);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#upd-emp-btn").click(function() {
		let id = $('input[name="emp"]:checkbox:checked').val();
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/EmployeeDetail?action=update",
			data: {
				id: id
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
				$("#employeeId").attr('readonly', true);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	function validatePhone(phone) {
		let regex = /^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$/;
		return regex.test(phone);
	}

	function validateEmail(email) {
		let regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
		return regex.test(email);
	}

	$("#FormDetail").submit(function(e) {
		e.preventDefault();
		var formData = new FormData(this);
		let id = $('input[name="employeeId"]').val();
		let name = $('input[name="name"]').val();
		let gender = $('input[name="gender"]').val();
		let dob = $('input[name="dob"]').val();
		let phone = $('input[name="phone"]').val();
		let address = $('input[name="address"]').val();
		let email = $('input[name="email"]').val();
		let workingPlace = $('input[name="workingPlace"]').val();
		let position = $('input[name="postion"]').val();
		let img = $('input[name="img"]').val();
		let check = true;

		if (!validateEmail(email)) {
			$("#message-email").html("Input Email not follow the format!!! (Format: abc@def.jqk.xyz OR abc@def.xyz)");
			check = false;
		}

		if (!validatePhone(phone)) {
			$("#message-phone").html("Input Phone Number not follow the format!!!");
			check = false;
		}
		if (check == false) {
			return false;
		} else {
			formData.append('id', id);
			formData.append('name', name);
			formData.append('gender', gender);
			formData.append('dob', dob);
			formData.append('phone', phone);
			formData.append('address', address);
			formData.append('email', email);
			formData.append('workingPlace', workingPlace);
			formData.append('position', position);
			formData.append('img', img);

			$.ajax({
				url: $(this).attr("action"),
				enctype: 'multipart/form-data',
				type: "post",
				data: formData,
				success: function(responseData) {
					$(".mycontent").html(responseData);
					// alert(formData);
				},
				error: function() {

				},
				processData: false,
				contentType: false
			});

		}
	});

	$("#del-emp-btn").on('click', function() {
		let checkedDelete = [];

		$("input[name='emp']:checked").each(function() {
			checkedDelete.push($(this).val());
		});

		$.confirm({
			title: 'Confirm',
			content: `<i class="fas fa-info-circle" style="color: green;"></i> ` + 'Are you sure to delete?',
			buttons: {
				OK: function() {
					$.ajax({
						url: "/cpl_java_03_vaccination_g1/EmployeeList",
						type: "post",
						data: {
							emp: checkedDelete
						},
						success: function(responseData) {
							$(".mycontent").html(responseData);
						},
						error: function() {

						},
					});
				},
				Cancel: function() {

				},
			}
		});
	});

	$("#VaccineCreate").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineCreateServletController",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#btnNewVaccine").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineCreateServletController",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#VaccineList").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ListVaccine",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("body").on("click", "a.update-vaccine-link", function() {
		var id = $(this).attr("value");
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineUpdateServletController",
			data: {
				vaccineId: id
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#buttonVaccineSave").click(function() {
		var vaccineId = $('#vaccineId');
		var status = $('#status').is(":checked");
		var name = $('#name');
		var type = $('#vaccineTypeSelect');
		var typeId = $('#vaccineTypeSelect option:selected').val();
		var numberInject = $('#numberInject').val();
		var usage = $('#usage').val();
		var indication = $('#indication').val();
		var contraindication = $('#contraindication').val();
		var begin = $('#begin').val();
		var end = $('#end').val();
		var origin = $('#origin').val();
		var action = $('#VaccineAction').val();

		var urlExtendsion = (action == "create") ? "/VaccineCreateServletController" : "/VaccineUpdateServletController";
		var check = true;
		setBorderColor(vaccineId);
		setBorderColor(name);
		setBorderColor(type);
		
		if (vaccineId.val() == "") {
			$('#error-id').html("Vaccine Id can not be empty!!");
			check = false;
		}
		else if (!validateVaccineId(vaccineId.val())) {
			vaccineId.style.borderColor = "red";
			$('#error-id').html("Vaccine Id only contain numbers!!");
			check = false;
		}
		if (name.val() == "") {
			$('#error-name').html("Vaccine Name can not be empty!!");
			check = false;
		}
		if (typeId == -1) {
			$('#error-type').html("Please select a vaccine type!!");
			check = false;
		}
		
		if (Date.parse(end) < Date.parse(begin)) {
			$('#error-end').html("Invalid time end!!");
			check = false;
		}
		if(check) {
			//alert("Vaccine saved!");
			$.ajax({
				type: "POST",
				url: "/cpl_java_03_vaccination_g1" + urlExtendsion,
				data: {
					vaccineId: vaccineId.val(),
					status: status,
					name: name.val(),
					typeId: typeId,
					numberInject: numberInject,
					usage: usage,
					indication: indication,
					contraindication: contraindication,
					begin: begin,
					end: end,
					origin: origin

				},
				success: function(responseData) {
					$(".mycontent").html(responseData);
					alert(action + " successfully!!!");
					// alert(responseData);
				},
				error: function() {
					alert(action + " failed!!!");

				}
			});
		}
	});

	$("#buttonVaccineCancel").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/ListVaccine",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#btnUpdateVaccine").click(function() {
		var id = $('input[name="vaccine"]:checkbox:checked').val();
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineUpdateServletController",
			data: {
				vaccineId: id
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#btnImportVaccine").click(function() {
		$.ajax({
			url: "/cpl_java_03_vaccination_g1/VaccineImportServletController",
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {

			}
		});
	});

	$("#btn-vaccine-import").click(function() {
		let file = $('#vaccine-file').val().split('\\').pop().split('/').pop();
		$.ajax({
			type: "POST",
			url: "/cpl_java_03_vaccination_g1/VaccineImportServletController",
			data: {
				file: file
			},
			success: function(responseData) {
				$(".mycontent").html(responseData);
				// alert(responseData);
			},
			error: function() {
				alert("Import failed!!");
			}
		});
	});

	$("#FormVList").submit(function(e) {
		e.preventDefault();
		let checkedInActive = [];

		$("input[name='vaccine']:checked").each(function() {
			checkedInActive.push($(this).val());
		});

		$.confirm({
			tittle: 'Confirm',
			content:`<i class="fas fa-info-circle" style="color: green;"></i> ` + 'Are you sure to make these vaccines Inactive?',
			buttons: {
				OK: function() {
					$.ajax({
						url: "/cpl_java_03_vaccination_g1/ListVaccine",
						type: "post",
						data: {
							vaccine: checkedInActive
						},
						success: function(responseData) {
							$(".mycontent").html(responseData);
						},
						error: function() {

						},
					});
				},
				Cancel: function() {

				},
			}
		});
	});
});

$(document).on('change', 'input[name="emp"]', function() {
	let checkedArray = $('input[name="emp"]:checkbox:checked').map(function() {
		return $(this).val();
	}).get();
	$('#upd-emp-btn').attr('disabled', checkedArray.length == 0 || checkedArray.length > 1);
	$('#del-emp-btn').attr('disabled', checkedArray.length == 0);
});

$(document).on('change', 'input[name="vaccine"]', function() {
	let checkedArray = $('input[name="vaccine"]:checkbox:checked').map(function() {
		return $(this).val();
	}).get();
	$('#btnUpdateVaccine').attr('disabled', checkedArray.length == 0 || checkedArray.length > 1);
	$('#btnMakeInactiveVaccine').attr('disabled', checkedArray.length == 0);
});
$(document).on('change', 'input[name="vaccinetypebox"]', function() {
	let checkedArray = $('input[name="vaccinetypebox"]:checkbox:checked').map(function() {
		return $(this).val();
	}).get();
	$('#btnMakeInAciveVaccineType').attr('disabled', checkedArray.length == 0);
});

//tai 
$(function() {
	$("#from").datepicker({
		numberOfMonths: 2,
		onSelect: function(selected) {
			var dt = new Date(selected);
			dt.setDate(dt.getDate() + 1);
			var current = new Date();
			$("#to").datepicker("option", "minDate", dt);
		}
	}).datepicker("option", "minDate", "today");
	$("#to").datepicker({
		numberOfMonths: 2,
		onSelect: function(selected) {
			var dt = new Date(selected);
			dt.setDate(dt.getDate() - 1);
			$("#from").datepicker("option", "maxDate", dt);
		}
	}).datepicker("option", "minDate", "today");
});

ClassicEditor
	.create(document.querySelector('#note'))
	.catch(error => {
		console.error(error);
	});

var dataTable = new simpleDatatables.DataTable("#datatablesSimple", {
	perPage: 5
});
$(document).ready(function() {
	$('#buttonScheduleUpdate').attr('disabled', 'disabled');
	$('input[type="radio"]').change(function() {
		if ($(this).val != '') {
			$('#buttonScheduleUpdate').removeAttr('disabled');
		}
	});
});