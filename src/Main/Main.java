package Main;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Pojoutil.ClassUtil;
import Pojoutil.StudentUtil;
import pojos.Admin;
import pojos.Classes;
import pojos.Student;
import pojos.Subjects;
import pojos.Teacher;
import pojos.TeachesAndSubject;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(".................. Developer Details.................");
        System.out.println("..Learner's Academy made with love By Bhuwan Agrawal....");
        System.out.println("....Student at Simplilearn..............................");
        System.out.println("Enter Admin name");
		String name=sc.nextLine();
		System.out.println("Enter Admin Password");
		String pswd=sc.nextLine();
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
        Transaction tx=s.beginTransaction();
        Admin a=new Admin();
        a.setName(name);
        a.setPassword(pswd);
        s.save(a);
        tx.commit();
        System.out.println("Admin Saved");
		
	}

}
