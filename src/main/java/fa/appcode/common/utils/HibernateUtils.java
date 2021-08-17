package fa.appcode.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	static {
		// Read configuration file: driver, url, database, account
		Configuration configuration = new Configuration();
		configuration.configure();
		
		// Create SessionFactory --> to create Session
		if (sessionFactory == null) {
			sessionFactory = configuration.buildSessionFactory();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
