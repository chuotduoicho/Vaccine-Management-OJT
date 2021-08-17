package fa.appcode.dao.dao;

import java.util.List;

import fa.appcode.web.entities.Employee;

public interface EmployeeDAO {
	// Show all employee in the database
	List<Employee> findAll();

	// Create new employee or update it if existed and set it into database
	boolean save(Employee employee);
	
	// Find employee by his/her id
	Employee findEmployeeByID(String id);

	// Delete an existed employee in database by his/her id
	boolean delete(String employeeId);
	
	// Login into program
	Employee checkLogin(String username, String password);
	
	// Find employee by his/her username for reseting password
	Employee findEmployeeByUsername(String username);
	
	// Find employee by his/her username for reseting password
	Employee findEmployeeByEmail(String email);

}
