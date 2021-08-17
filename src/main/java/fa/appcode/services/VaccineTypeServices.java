package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.VaccineType;

public interface VaccineTypeServices {
	// Show all vaccine type in database
	List<VaccineType> findAllVaccineType();

	// Create new vaccine type and set it into database
	boolean save(VaccineType vaccineType);

	// Update vaccine type and set it into database
	boolean updateVaccineType(VaccineType vaccineType);
	
	//Get vaccine type by code
	VaccineType findbyCode(String vaccineTypeCode);
	
	//Make in-active status
	boolean makeInactive(String id);
			
}
