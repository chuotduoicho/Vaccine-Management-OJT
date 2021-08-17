package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineSchedule;

public interface ScheduleService {
	// Show all schedule in the database
	List<VaccineSchedule> findAll();
	
	// Show all vaccine in the database
	List<Vaccine> findAllVaccine();

	// Create new schedule and set it into database
	void create(VaccineSchedule vaccineSchedule);

	// Get an schedule by his/her id
	VaccineSchedule findById(int vaccineScheduleId);

	// Update an existed schedule in database by his/her id
	void update(VaccineSchedule vaccineSchedule);
}
