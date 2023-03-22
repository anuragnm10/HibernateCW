package com.gl.HibernateMavenDemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.gl.HibernateMavenDemo.config.HibernateConfig;
import com.gl.HibernateMavenDemo.entity.Employee;
import com.gl.HibernateMavenDemo.entity.Identification;


public class AppOneToOne 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
    	Session session = factory.openSession();
    	Employee emp = session.get(Employee.class, "001");
    	session.close();
    	System.out.println(emp.getEmail());
    	System.out.println(emp.getEmpname());
    	System.out.println(emp.getIdentification());
    	System.out.println();
    	session = factory.openSession();
    	Identification id = session.get(Identification.class, "001");
    	session.close();
    	System.out.println(id.getFullname());
    	System.out.println(id.getBdate());
    	System.out.println(id.getEmp().getPhone());
    }
    
}