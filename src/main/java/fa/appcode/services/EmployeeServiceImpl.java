package fa.appcode.services;

import java.util.List;

import fa.appcode.common.logging.Logging;
import fa.appcode.dao.dao.EmployeeDAO;
import fa.appcode.dao.dao.EmployeeDAOImpl;
import fa.appcode.web.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> findAll() {
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.findAll();
	}

	@Override
	public boolean create(Employee employee) throws Exception {
		// Validate null
		if (employee == null) {
			Logging.getLog().error("Employee Invalid!!!");
			throw new Exception("Employee Invalid!!!");
		}
		// Validate existed id
		List<Employee> employees = findAll();
		String id = employee.getId();
		for (Employee emp : employees) {
			if (id.equals(emp.getId())) {
				Logging.getLog().error("Employee ID has been existed!!!");
				/* throw new Exception("Employee ID has been existed!"); */
			}
		}
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.save(employee);
	}

	@Override
	public Employee findEmployeeByID(String id) {
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.findEmployeeByID(id);
	}

	@Override
	public boolean update(Employee employee) throws Exception {
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.save(employee);
	}

	@Override
	public boolean delete(String employeeId) {
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.delete(employeeId);
	}

	@Override
	public Employee checkLogin(String username, String password) {
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.checkLogin(username, password);
	}

	@Override
	public Employee findEmployeeByUsername(String username) {
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.findEmployeeByUsername(username);
	}



	@Override
	public Employee findEmployeeByEmail(String email) {
		// Call DAO
		employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.findEmployeeByEmail(email);
	}

}
