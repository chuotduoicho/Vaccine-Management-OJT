package fa.appcode.services;

import java.util.List;

import fa.appcode.common.logging.Logging;
import fa.appcode.dao.dao.VaccineTypeDAO;
import fa.appcode.dao.dao.VaccineTypeDAOImpl;
import fa.appcode.web.entities.Employee;
import fa.appcode.web.entities.VaccineType;

public class VaccineTypeServicesImpl implements VaccineTypeServices {

	private VaccineTypeDAO vaccineTypeDAO;
	
	@Override
	public List<VaccineType> findAllVaccineType() {
		 vaccineTypeDAO = new VaccineTypeDAOImpl();
		return vaccineTypeDAO.findAllVaccineType();
		
	}

	@Override
	public boolean save(VaccineType vaccineType) {
		//Validate
		if (vaccineType == null) {
			throw new IllegalArgumentException("VaccineType invalid!");
		}
		// Validate existed id
				List<VaccineType> vaccineTypes = findAllVaccineType();
				String id = vaccineType.getId();
				
				for (VaccineType vaccineType2 : vaccineTypes) {
					if (id.equals(vaccineType2.getId())) {
						Logging.getLog().error("VaccineType ID has been existed!!!");
						/* throw new Exception("VaccineType ID has been existed!"); */
					}
				}
		// Call DAO
				vaccineTypeDAO = new VaccineTypeDAOImpl();
				return vaccineTypeDAO.save(vaccineType);
		
	}

	@Override
	public boolean updateVaccineType(VaccineType vaccineType) {
		//Validate
		if (vaccineType == null) {
			throw new IllegalArgumentException("VaccineType invalid!");
		}
		// Call DAO
		vaccineTypeDAO = new VaccineTypeDAOImpl();
		return vaccineTypeDAO.save(vaccineType);
	}

	@Override
	public VaccineType findbyCode(String vaccineTypeCode) {
		
		vaccineTypeDAO = new VaccineTypeDAOImpl();
		return vaccineTypeDAO.findbyCode(vaccineTypeCode);
	}

	@Override
	public boolean makeInactive(String id) {
		vaccineTypeDAO = new VaccineTypeDAOImpl();
		return vaccineTypeDAO.makeInactive(id);
	}

}
