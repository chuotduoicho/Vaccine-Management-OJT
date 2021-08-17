package fa.appcode.dao.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.appcode.common.logging.Logging;
import fa.appcode.dao.dao.VaccineDAO;
import fa.appcode.dao.dao.VaccineDAOImpl;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineType;

class VaccineDAOTest {
	static VaccineDAO vaccineDAO;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		vaccineDAO = new VaccineDAOImpl();
	}

	@Test
	void testFindAllVaccine() {
		List<Object[]> actual = vaccineDAO.findAllVaccine();
		Assertions.assertFalse(actual.isEmpty());
		Logging.getLog().info("Test listing done!");
	}
	
	@Test
	void testAddVaccineNormal() {
		VaccineType type = new VaccineType();
		type.setId("01");
		Vaccine vaccine = new Vaccine("0013", false, "Vaccine 13", type, 10, null, null, null, null, null, null);
		boolean actualResult = vaccineDAO.saveVaccine(vaccine);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Test save done");
	}

	@Test
	void testAddVaccineAbnormal() {
		VaccineType type = new VaccineType();
		type.setId("01");
		Vaccine vaccine = null;
		//assertThrows(IllegalArgumentException.class, () -> {vaccineDAO.add(vaccine);});
		boolean actualResult = vaccineDAO.saveVaccine(vaccine);
		Assertions.assertFalse(actualResult);
		Logging.getLog().info("Test save done!");
	}
	
	@Test
	void testGetVaccineByIdNormal() {
		VaccineType type = new VaccineType();
		type.setId("01");
		Vaccine expected = new Vaccine("0013", false, "Vaccine 13", type, 10, null, null, null, null, null, null);
		vaccineDAO = new VaccineDAOImpl();
		Vaccine actual = vaccineDAO.findById(expected.getId());
		assertEquals(expected, actual);
		Logging.getLog().info("Test find by id done!");		
	}
	
	@Test
	void testGetVaccineByIdAbNormal() {
		Vaccine expected = null;
		Vaccine actual = vaccineDAO.findById("9999");
		assertEquals(expected, actual);
		Logging.getLog().info("Test find by id done!");
	}
	
	@Test
	void testUpdateVaccineNormal(){
		VaccineType type = new VaccineType();
		type.setId("01");
		Vaccine expected = new Vaccine("0013", true, "Vaccine 13.1", type, 100, null, null, null, null, null, "Russia");
		boolean actualResult = vaccineDAO.saveVaccine(expected);
		//Vaccine actual = vaccineDAO.findById(expected.getId());
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Test update done!");
	}
	
	@Test
	void testMakeVaccineInactiveNormal() {
		String vaccineId = "0001";
		boolean actualResult = vaccineDAO.makeInactive(vaccineId);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Test make inactive done!");
	}
	
	@Test
	void testMakeVaccineInactiveAbnormal() {
		String vaccineId = null;
		boolean actualResult = vaccineDAO.makeInactive(vaccineId);
		Assertions.assertFalse(actualResult);
		Logging.getLog().info("Test make inactive done!");
	}
}
