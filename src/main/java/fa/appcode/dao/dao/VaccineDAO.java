package fa.appcode.dao.dao;

import java.util.List;

import fa.appcode.web.entities.Vaccine;

public interface VaccineDAO {
	
	List<Object[]> findAllVaccine();
	
	Vaccine findById(String id);
	
	boolean saveVaccine(Vaccine vaccine);
	
	boolean makeInactive(String id);
}
