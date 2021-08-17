package fa.appcode.dao.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fa.appcode.common.logging.Logging;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineSchedule;

class ScheduleDAOTest {
	static ScheduleDAO scheduleDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		scheduleDAO = new ScheduleDAOImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFindAllNormal() {
		List<VaccineSchedule> actualResult = scheduleDAO.findAll();
		Logging.getLog().info("Actual List Result: " + actualResult.size());
		Assertions.assertFalse(actualResult.isEmpty());
		Logging.getLog().info("Actual List null? " + actualResult.isEmpty());
		Logging.getLog().info("Test Find All Success!");
	}
	
	@Test
	void testFindAllAbnormal() {
		List<VaccineSchedule> actualResult = scheduleDAO.findAll();
		Logging.getLog().info("Actual List Result: " + actualResult.size());
		Assertions.assertTrue(actualResult.isEmpty());
		Logging.getLog().info("Actual List null? " + actualResult.isEmpty());
		Logging.getLog().info("Test Find All Failed!");
	}
	
	@Test
	void testCreateNormal() {
		Vaccine vaccine = new Vaccine();
		vaccine.setId("3");
		VaccineSchedule vaccineSchedule = new VaccineSchedule(1, vaccine,
				LocalDate.of(2020, 12, 4), LocalDate.of(2021, 12, 4), "Place 1",
				"Note 1 ");
		boolean actualResult = scheduleDAO.save(vaccineSchedule);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Test Save Done!");
	}

	@Test
	void testCreateAbnormal() {
		VaccineSchedule sche = null;
		boolean actualResult = scheduleDAO.save(sche);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Test Save Failed!");
	}

	@Test
	void testFindScheduleByIDNormal() {
		int id = 10;
		VaccineSchedule actualResult = scheduleDAO.findById(id);
		Assertions.assertFalse(actualResult == null);
		Logging.getLog().info("Actual Employee null? " + (actualResult == null));
		Logging.getLog().info("Test Find By ID Success!");
	}
	
	@Test
	void testFindScheduleByIDAbnormal() {
		int id=-4;
		VaccineSchedule actualResult = scheduleDAO.findById(id);
		Assertions.assertFalse(actualResult == null);
		Logging.getLog().info("Actual Employee null? " + (actualResult == null));
		Logging.getLog().info("Test Find By ID Failed!");
	}

	@Test
	void testFindEmployeeByIDNormal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFindEmployeeByIDAbnormal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

}