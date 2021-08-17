/**
 * 
 */
function setBorderColor(element) {
	if (element.value == "" || element.value == "-1") {
		element.style.borderColor = "red";
	} else {
		element.style.borderColor = "green";
	}
}

function validateVaccineId(id){
	var re = /^[0-9]+$/;
	return re.test(id);
}