package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.Employee;

public interface EmployeeService {
	// Show all employee in the database
	List<Employee> findAll();

	// Create new employee and set it into database
	boolean create(Employee employee) throws Exception;

	// Find employee by his/her id
	Employee findEmployeeByID(String id);
	
	// Update an existed employee
	boolean update(Employee employee) throws Exception;

	// Delete an existed employee in database by his/her id
	boolean delete(String employeeId);

	// Login into program
	Employee checkLogin(String username, String password);

	// Find employee by his/her username for reseting password
	Employee findEmployeeByUsername(String username);
	
	// Find employee by his/her username for reseting password
	Employee findEmployeeByEmail(String email);

}
