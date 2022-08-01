package Pojoutil;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Hibernateutil.HibernateUtil;
import pojos.Classes;
import pojos.Subjects;

public class SubjectUtil {
      public static List <Subjects> getAllSubjects()
      {
    	  HibernateUtil hu=new HibernateUtil();
    	 // SessionFactory sf=hu.getSessionFactory();
    	  //Session s=sf.getCurrentSession();
    	  Session s=hu.getSessionFactory();
    	  Criteria c=s.createCriteria(Subjects.class);
    	  List<Subjects> li=c.list();

    	  return li;
      }
      public static Subjects getSubjectById(int id) {
  		HibernateUtil hu=new HibernateUtil();
  		//SessionFactory sf=hu.getSessionFactory();
  		//Session s=sf.getCurrentSession();
  		Session s=hu.getSessionFactory();
  		Subjects subject= s.find(Subjects.class,id);
  		return subject;
  	}
      
      public static void deleteSubjectById(int id)
  	{
  		
  		HibernateUtil hu=new HibernateUtil();
  		//SessionFactory sf=hu.getSessionFactory();
  		//Session s=sf.getCurrentSession();
  		Session s=hu.getSessionFactory();
  		Subjects subject= s.find(Subjects.class,id);
  		Transaction tx=s.beginTransaction();
  		s.remove(subject);
  		tx.commit();
  		
  	}


}
