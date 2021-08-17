package fa.appcode.dao.dao;

import java.util.List;

import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineSchedule;

public interface ScheduleDAO {
	// Show all schedule in the database
	List<VaccineSchedule> findAll();
	
	// Show all vaccine in the database
	List<Vaccine> findAllVaccine();


	// Get an schedule by his/her id
	VaccineSchedule findById(int vaccineId);

	// Create an schedule by his/her id
	boolean save(VaccineSchedule vaccineSchedule);

	
	
}
