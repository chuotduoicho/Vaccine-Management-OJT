package fa.appcode.dao.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fa.appcode.common.logging.Logging;
import fa.appcode.common.utils.HibernateUtils;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineSchedule;

public class ScheduleDAOImpl implements ScheduleDAO {

	private SessionFactory sessionFactory;
	@Override
	public List<VaccineSchedule> findAll() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			List<VaccineSchedule> schedules = session
					.createQuery("FROM VaccineSchedule", VaccineSchedule.class)
					.list();
			return schedules;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}


	@Override
	public VaccineSchedule findById(int scheduleId) {
		List<VaccineSchedule> schedules = findAll();
		for (VaccineSchedule e : schedules) {
			if (scheduleId==e.getId()) {
				return e;
			}
		}
		return null;
	}

	@Override
	public boolean save(VaccineSchedule vaccineSchedule) {
		Session session = null;

		try {
			sessionFactory = HibernateUtils.getSessionFactory();

			session = sessionFactory.openSession();
			// Getting transaction object from session object
			session.beginTransaction();

			session.saveOrUpdate(vaccineSchedule);

			Logging.getLog().info("Insert Successfully!!!");

			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Logging.getLog().error("Insert Failed!!!");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public List<Vaccine> findAllVaccine() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			List<Vaccine> Vaccines = session
					.createQuery("FROM Vaccine", Vaccine.class).list();
			return Vaccines;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

}