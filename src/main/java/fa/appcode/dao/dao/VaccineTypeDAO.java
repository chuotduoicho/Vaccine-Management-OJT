package fa.appcode.dao.dao;

import java.util.List;

import fa.appcode.web.entities.VaccineType;

public interface VaccineTypeDAO {
	//Show all vaccine type in database
		List<VaccineType> findAllVaccineType();
		
		//Create new vaccine type and set it into database
		boolean save(VaccineType vaccineType);
		
		//Update vaccine type and set it into database
		boolean updateVaccineType(VaccineType vaccineType,String id);
		
		//Get vaccine type by code
		VaccineType findbyCode(String vaccineTypeCode);
		
		//
		boolean makeInactive(String id);
}
