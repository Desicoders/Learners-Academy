package Pojoutil;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Hibernateutil.HibernateUtil;
import pojos.Classes;
import pojos.Subjects;

public class ClassUtil {
	public static List <Classes> getAllClasses()
    {
  	  HibernateUtil hu=new HibernateUtil();
		//SessionFactory sf=hu.getSessionFactory();

  	  Session s=hu.getSessionFactory();
  	  Criteria c=s.createCriteria(Classes.class);
  	  List<Classes> li=c.list();
  	  return li;
    }
	public static Classes getClassById(int id) {
		HibernateUtil hu=new HibernateUtil();
		//SessionFactory sf=hu.getSessionFactory();
		Session s=hu.getSessionFactory();
		Classes c= s.find(Classes.class,id);
	
		return c;
	}
	public static void deleteClassById(int id)
	{
		
		HibernateUtil hu=new HibernateUtil();
		//SessionFactory sf=hu.getSessionFactory();
		Session s=hu.getSessionFactory();
		Classes c= s.find(Classes.class,id);
		Transaction tx=s.beginTransaction();
		s.remove(c);
		tx.commit();
		
	}

}
