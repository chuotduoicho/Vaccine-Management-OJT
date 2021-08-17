package fa.appcode.dao.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fa.appcode.common.logging.Logging;
import fa.appcode.common.utils.HibernateUtils;
import fa.appcode.web.entities.Vaccine;



public class VaccineDAOImpl implements VaccineDAO{

	private SessionFactory sessionFactory;
	@Override
	public List<Object[]> findAllVaccine() {
		Session session = null;
		try {			
			sessionFactory = HibernateUtils.getSessionFactory();		      
		    
			session = sessionFactory.openSession();
			
			Logging.getLog().info("Find All Vaccine!!!");
		    
			Query query = session.createQuery("SELECT v.id, v.name, v.numberOfInject, v.origin, t.name, v.status FROM Vaccine v LEFT JOIN v.type t");
		    
			Logging.getLog().info("Read successfully!");
			return query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			Logging.getLog().info("Read failed!");
		}finally {
			if (session != null) {
		        session.close();
		      }
		}
		return null;
	}
	@Override
	public Vaccine findById(String id) {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			
			session = sessionFactory.openSession();
			
			Logging.getLog().info("Find Vaccine By ID!!!");
			
			Vaccine vaccine = session.get(Vaccine.class, id);
			
			return vaccine;
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		Logging.getLog().info("Find Vaccine Failed!!!");
		
		return null;
	}
	
	@Override
	public boolean makeInactive(String id) {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			
			session = sessionFactory.openSession();
			
			Logging.getLog().info("Make In-active Vaccine!!!");
			
			session.beginTransaction();
			Vaccine vac = session.get(Vaccine.class, id);
			vac.setStatus(false);
			session.getTransaction().commit();
			Logging.getLog().info("Make In-active Successfully!!!");
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			Logging.getLog().error("Make In-active Failed!!!");
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return false;
	}
	@Override
	public boolean saveVaccine(Vaccine vaccine) {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.saveOrUpdate(vaccine);
			session.getTransaction().commit();
			return true;
		}catch(Exception exception) {
			Logging.getLog().info("Save Vaccine Failed!!!");
		}
		return false;
	}

}