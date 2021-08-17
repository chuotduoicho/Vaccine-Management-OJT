package fa.appcode.dao.dao;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fa.appcode.common.logging.Logging;
import fa.appcode.web.entities.VaccineType;

class VaccineTypeDAOTest {
	static VaccineTypeDAO vacineTypeDao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		vacineTypeDao = new VaccineTypeDAOImpl();
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
	@Order(1)
	void testFindAllVaccineType() {
		List<VaccineType> resultlist = vacineTypeDao.findAllVaccineType();
		Assertions.assertFalse(resultlist.isEmpty());
	}

	@Test
	@Order(2)
	void testInsertVaccineTypeNomal() {
		VaccineType vaccineType = new VaccineType("VCT1", "Pfizer", true, "Against Covid Deta", null);
		boolean actualResult = vacineTypeDao.save(vaccineType);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Test Insert Done!");
	}
	
	@Test
	@Order(3)
	void testInsertVaccineTypeAbnomal() {
		VaccineType vaccineType = null;
		
		
		boolean actualResult = vacineTypeDao.save(vaccineType);
		Assertions.assertFalse(actualResult);
		
		Logging.getLog().info("Test Insert Done!");
	}

	@Test
	@Order(4)
	void testUpdateVaccineTypeNomal() {
		VaccineType vaccineType = new VaccineType("VCT1", "moderna", false, "Against Covid", null);
		boolean actualResult = vacineTypeDao.save(vaccineType);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Test Update Done!");
	}
	
	@Test
	@Order(5)
	void testUpdateVaccineTypeAbnomal() {
		VaccineType vaccineType = null;
		boolean actualResult = vacineTypeDao.save(vaccineType);
		Assertions.assertFalse(actualResult);
		Logging.getLog().info("Test Update Done!");
	}

	@Test
	@Order(6)
	void testFindbyCode() {
		String id = "CV01";
		VaccineType vaccineType = vacineTypeDao.findbyCode(id);
		assertEquals("astrazeneca", vaccineType.getName());
		Logging.getLog().info("Test Find Code Done!");
	}

}
