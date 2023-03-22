package com.gl.HibernateMavenDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateMavenDemo.config.HibernateConfig;
import com.gl.HibernateMavenDemo.entity.Author;


public class AppHQL 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
    	Session session = factory.openSession();
    	
    	List<Author> authors = session.createQuery("from Author where name like 'c%'", Author.class)
//    			.setParameter("genre", "BIT")
//    			.setParameter("year", 2014)
    			.setMaxResults(2)
    			.getResultList();
    	session.close();
    	
    	for(Author val : authors) {
    		System.out.println(val);
    	}
    	
//    	Session session1 = factory.openSession();
//    	
//    	long count = session1.createQuery("select aid, name from Author", Long.class)
//    			.uniqueResult();
//    	System.out.println(count);
    }
    
}
