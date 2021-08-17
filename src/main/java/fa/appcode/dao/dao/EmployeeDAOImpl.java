package fa.appcode.dao.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fa.appcode.common.logging.Logging;
import fa.appcode.common.utils.HibernateUtils;
import fa.appcode.web.entities.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<Employee> findAll() {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
			Logging.getLog().info("Read Successfully!!!");
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
			Logging.getLog().error("Read Failed!!!");
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public boolean save(Employee employee) {
		Session session = null;

		try {
			sessionFactory = HibernateUtils.getSessionFactory();

			session = sessionFactory.openSession();
			// Getting transaction object from session object
			session.beginTransaction();

			session.saveOrUpdate(employee);

			Logging.getLog().info("Save Successfully!!!");

			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Logging.getLog().error("Save Failed!!!");
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return false;
	}

	@Override
	public Employee findEmployeeByID(String id) {
		List<Employee> employees = findAll();

		for (Employee employee : employees) {
			if (id.equals(employee.getId())) {
				return employee;
			}
		}

		return null;
	}
	
	@Override
	public Employee findEmployeeByEmail(String email) {
		List<Employee> employees = findAll();
		
		for (Employee employee : employees) {
			if (email.equals(employee.getEmail())) {
				return employee;
			}
		}
		
		return null;
	}

	@Override
	public boolean delete(String employeeId) {
		Session session = null;

		try {
			sessionFactory = HibernateUtils.getSessionFactory();

			session = sessionFactory.openSession();
			
			session.beginTransaction();

			Query query = session.createQuery("DELETE Employee WHERE id = :empId");

			query.setParameter("empId", employeeId);

			int result = query.executeUpdate();
			
			session.getTransaction().commit();

			if (result > 0) {
				Logging.getLog().info("Delete Successfully!!!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Logging.getLog().error("Delete Failed!!!");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public Employee checkLogin(String username, String password) {
		try {
			Employee employee = findEmployeeByUsername(username);
			
			if (password.equals(employee.getPassword())) {
				Logging.getLog().info("Login Successfully!!!");
				return employee;
			}
		} catch (Exception e) {
			Logging.getLog().error("Login Failed!!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee findEmployeeByUsername(String username) {
		List<Employee> employees = findAll();

		for (Employee employee : employees) {
			if (username.equals(employee.getUsername())) {
				return employee;
			}
		}
		return null;
	}


}
