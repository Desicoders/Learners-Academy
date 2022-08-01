package Hibernateutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sf=null;
	static Session session=null;
	static{
		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session=sf.openSession();
	}
	public  Session getSessionFactory() {
		if(sf==null) {
			sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session=sf.openSession();
		}
		return session;
	}
	
	public static void closeSessionFactory() {
		if(sf!=null)
			sf.close();
		sf=null;
	}
}
