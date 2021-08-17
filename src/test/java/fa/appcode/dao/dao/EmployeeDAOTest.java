package fa.appcode.dao.dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fa.appcode.common.logging.Logging;
import fa.appcode.web.entities.Employee;

class EmployeeDAOTest {
	static EmployeeDAO employeeDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		employeeDAO = new EmployeeDAOImpl();
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
	void testFindAllNormal() {
		List<Employee> actualResult = employeeDAO.findAll();
		Logging.getLog().info("Actual List Result: " + actualResult.size());
		Assertions.assertFalse(actualResult.isEmpty());
		Logging.getLog().info("Actual List null? " + actualResult.isEmpty());
		Logging.getLog().info("Test Find All Success!");
	}

	@Test
	void testFindAllAbnormal() {
		List<Employee> actualResult = employeeDAO.findAll();
		Logging.getLog().info("Actual List Result: " + actualResult.size());
		Assertions.assertTrue(actualResult.isEmpty());
		Logging.getLog().info("Actual List null? " + actualResult.isEmpty());
		Logging.getLog().info("Test Find All Failed!");
	}

	@Test
	/**
	 * Test for save method - normal create/update action
	 */
	void testCreateNormal() {
		Employee emp = new Employee("HE152020", "Le Hong Quang", true, LocalDate.of(2000, 12, 4), "0514269768",
				"Nowhere", "QuangLQ@vtv.vn", "Europe", "Reporter", null);
		boolean actualResult = employeeDAO.save(emp);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Is Save Work? " + actualResult);
		Logging.getLog().info("Test Save Success!");
	}

	@Test
	/**
	 * Test for save method - abnormal create/update action
	 */
	void testCreateAbnormal() {
		Employee emp = null;
		boolean actualResult = employeeDAO.save(emp);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Is Save Work? " + actualResult);
		Logging.getLog().info("Test Save Failed!");
	}

	@Test
	void testFindEmployeeByIDNormal() {
		String id = "Yamaha";
		Employee actualResult = employeeDAO.findEmployeeByID(id);
		Assertions.assertFalse(actualResult == null);
		Logging.getLog().info("Actual Employee null? " + (actualResult == null));
		Logging.getLog().info("Test Find By ID Success!");
	}

	@Test
	void testFindEmployeeByIDAbnormal() {
		String id = "Yamaha123456789";
		Employee actualResult = employeeDAO.findEmployeeByID(id);
		Assertions.assertFalse(actualResult == null);
		Logging.getLog().info("Actual Employee null? " + (actualResult == null));
		Logging.getLog().info("Test Find By ID Failed!");
	}

	@Test
	void testDeleteNormal() {
		String id = "Yamaha4";
		boolean actualResult = employeeDAO.delete(id);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Is Delete Work? " + actualResult);
		Logging.getLog().info("Test Delete Done!");
	}

	@Test
	void testDeleteAbnormal() {
		String id = "Yamaha123456";
		boolean actualResult = employeeDAO.delete(id);
		Assertions.assertTrue(actualResult);
		Logging.getLog().info("Is Delete Work? " + actualResult);
		Logging.getLog().info("Test Delete Failed!");
	}

	@Test
	void testCheckLoginNormal() {
		String username = "nghiant34";
		String password = "123";
		Employee actualResult = employeeDAO.checkLogin(username, password);
		Assertions.assertTrue(actualResult != null);
		Logging.getLog().info("Logged in? " + actualResult);
		Logging.getLog().info("Test Login Done!");
	}

	@Test
	void testCheckLoginAbnormal() {
		String username = "nghiant34";
		String password = "456";
		Employee actualResult = employeeDAO.checkLogin(username, password);
		Assertions.assertFalse(actualResult != null);
		Logging.getLog().info("Logged in? " + actualResult);
		Logging.getLog().info("Test Login Done!");
	}

	@Test
	void testFindEmployeeByUsernameNormal() {
		String username = "nghiant34";
		Employee actualResult = employeeDAO.findEmployeeByUsername(username);
		Assertions.assertTrue(actualResult != null);
		Logging.getLog().info("Account not null? " + (actualResult != null));
		Logging.getLog().info("Test Find By Username Done!!!");
	}

	@Test
	void testFindEmployeeByUsernameAbnormal() {
		String username = "nghiant1234";
		Employee actualResult = employeeDAO.findEmployeeByUsername(username);
		Assertions.assertFalse(actualResult != null);
		Logging.getLog().info("Account not null? " + (actualResult != null));
		Logging.getLog().info("Test Find By Username Done!!!");
	}

}
