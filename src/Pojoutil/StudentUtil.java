package Pojoutil;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Hibernateutil.HibernateUtil;
import pojos.Classes;
import pojos.Student;
import pojos.Subjects;

public class StudentUtil {
	public static List<Student> getAllStudents() {
		HibernateUtil hu = new HibernateUtil();
		//SessionFactory sf = hu.getSessionFactory();
		//Session s = sf.openSession();
		Session s=hu.getSessionFactory();
		Criteria c = s.createCriteria(Student.class);
		List<Student> li = c.list();
//		s.close();

		return li;
	}

	public static Student getStudentById(int id) {
		HibernateUtil hu = new HibernateUtil();
		//SessionFactory sf = hu.getSessionFactory();
		//Session s = sf.getCurrentSession();
		Session s=hu.getSessionFactory();
		Student student = s.find(Student.class, id);

		return student;
	}

	public static List<Student> getStudentsbyClass(Classes clazz) {
		HibernateUtil hu = new HibernateUtil();
		//SessionFactory sf = hu.getSessionFactory();
		//Session s = sf.getCurrentSession();
		Session s=hu.getSessionFactory();
		Criteria c = s.createCriteria(Student.class);
		c.add(Restrictions.eq("assignedClasses.id", clazz.getId()));
		return c.list();

	}
	public static void deleteStudentById(int id)
	{
		
		HibernateUtil hu=new HibernateUtil();
		//SessionFactory sf=hu.getSessionFactory();
		//Session s=sf.openSession();
		Session s=hu.getSessionFactory();
		Student student= s.find(Student.class,id);
		Transaction tx=s.beginTransaction();
		s.remove(student);
		tx.commit();
		
	}


}
