package fa.appcode.services;

import java.util.List;

import fa.appcode.common.logging.Logging;
import fa.appcode.dao.dao.ScheduleDAO;
import fa.appcode.dao.dao.ScheduleDAOImpl;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineSchedule;

public class ScheduleServiceImpl implements ScheduleService{

	private ScheduleDAO scheduleDAO;

	@Override
	public List<VaccineSchedule> findAll() {
		scheduleDAO = new ScheduleDAOImpl();
		return scheduleDAO.findAll();
	}

	@Override
	public void create(VaccineSchedule vaccineSchedule) {
		// Validate null
		if (vaccineSchedule == null) {
			Logging.getLog().error("Schedule Invalid!!!");
			throw new IllegalArgumentException();
		}
		// Call DAO
		scheduleDAO = new ScheduleDAOImpl();
		scheduleDAO.save(vaccineSchedule);
	}

	@Override
	public VaccineSchedule findById(int vaccineScheduleId) {
		scheduleDAO = new ScheduleDAOImpl();
		return scheduleDAO.findById(vaccineScheduleId);
	}

	@Override
	public void update(VaccineSchedule vaccineSchedule) {
		// Validate null
		if (vaccineSchedule == null) {
			Logging.getLog().error("Schedule Invalid!!!");
			throw new IllegalArgumentException();
		}
		// Call DAO
		scheduleDAO = new ScheduleDAOImpl();
		scheduleDAO.save(vaccineSchedule);
	}

	@Override
	public List<Vaccine> findAllVaccine() {
		scheduleDAO = new ScheduleDAOImpl();
		return scheduleDAO.findAllVaccine();
	}

}
