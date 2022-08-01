package Pojoutil;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Hibernateutil.HibernateUtil;
import pojos.Classes;
import pojos.Subjects;
import pojos.Teacher;

public class TeacherUtil {
	public static List<Teacher> getAllTeachers() {
		HibernateUtil hu = new HibernateUtil();
		//SessionFactory sf = hu.getSessionFactory();
		//Session s = sf.openSession();
		Session s=hu.getSessionFactory();
		Criteria c = s.createCriteria(Teacher.class);
		List<Teacher> li = c.list();

		return li;
	}

	public static Teacher getTeacherById(int id) {
		HibernateUtil hu = new HibernateUtil();
		//SessionFactory sf = hu.getSessionFactory();
		//Session s = sf.openSession();
		Session s=hu.getSessionFactory();
		Teacher teacher = s.find(Teacher.class, id);
		return teacher;
	}
	
	public static void deleteTeacherById(int id)
	{
		
		HibernateUtil hu=new HibernateUtil();
		//SessionFactory sf=hu.getSessionFactory();
		//Session s=sf.openSession();
		Session s=hu.getSessionFactory();
		Teacher teacher= s.find(Teacher.class,id);
		Transaction tx=s.beginTransaction();
		s.remove(teacher);
		tx.commit();
		
	}

	

}
