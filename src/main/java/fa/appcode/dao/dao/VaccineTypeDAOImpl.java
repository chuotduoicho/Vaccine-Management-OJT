package fa.appcode.dao.dao;

import fa.appcode.common.logging.Logging;
import java.util.Base64;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fa.appcode.common.utils.HibernateUtils;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineType;

public class VaccineTypeDAOImpl implements VaccineTypeDAO {
	private SessionFactory sessionFactory;

	@Override
	public List<VaccineType> findAllVaccineType() {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			List<VaccineType> vaccineTypes = session.createQuery("FROM VaccineType", VaccineType.class).list();
			return vaccineTypes;
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
	public boolean save(VaccineType vaccineType) {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			// Getting transaction object from session object
			session.beginTransaction();
			
			
			
			session.saveOrUpdate(vaccineType);
			session.getTransaction().commit();
                        return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateVaccineType(VaccineType vaccineType,String id) {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
                        
                        // Getting transaction object from session object
			session.beginTransaction();
			Query query = session.createQuery(
					"update VaccineType set name = :typeName, status = :typeStatus, description = :description, urlImage = :urlImage where id = :typeId");
			query.setParameter("typeName", vaccineType.getName());
			query.setParameter("typeStatus", vaccineType.isStatus());
			query.setParameter("description", vaccineType.getDescription());
			query.setParameter("urlImage", vaccineType.getUrlImage());
			query.setParameter("typeId", id);
			int result = query.executeUpdate();
                        session.getTransaction().commit();
			
			if (result > 0) {
				Logging.getLog().info("Update Successfully!!!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public VaccineType findbyCode(String vaccineTypeCode) {
		List<VaccineType> vaccineTypes = findAllVaccineType();
		for (VaccineType vaccineType : vaccineTypes) {
			if (vaccineTypeCode.equals(vaccineType.getId())) {
				return vaccineType;
			}
		}
		return null;
	}

	@Override
	public boolean makeInactive(String id) {
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			
			session = sessionFactory.openSession();
			
			Logging.getLog().info("Make In-active VaccineType!!!");
			
			session.beginTransaction();
			VaccineType vaccineType = session.get(VaccineType.class, id);
			vaccineType.setStatus(false);
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

}
