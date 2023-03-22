package com.gl.HibernateMavenDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateMavenDemo.config.HibernateConfig;
import com.gl.HibernateMavenDemo.entity.Author;


public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
//    	System.out.println(getAuthorByID(12));
//		System.out.println(author.getClass().getName());
		System.out.println("********");
		// load throws an exception for the object if it does not exists
		System.out.println(loadAuthorByID(3));
    	
    	
    }
    
    public static int insertAuthor(Author author) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(author);
    	tx.commit();
    	session.close();
    	return author.getAid();
    }
    
    public static Author updateAuthor(Author author) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	Author updatedAuthor = session.merge(author);
		tx.commit();
		session.close();
		return updatedAuthor;
    }
    
    public static void deleteAuthor(Author author) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.remove(author);
    	tx.commit();
    	session.close();
    }
    
    
    public static Author getAuthorByID(int aid) {
    	Session session = factory.openSession();
    	Author author = session.get(Author.class, aid);
    	session.close();
    	return author;
    }
    
    public static Author loadAuthorByID(int aid) {
    	Session session = factory.openSession();
    	Author author = new Author();
    	
    	session.load(author, aid);
    	session.close();
    	return author;
    }
    
    public static List<Author> getAllAuthors(){
    	Session session = factory.openSession();
//    	List<Author> author = session.createQuery("Select a from Author a", Author.class).getResultList();
    	List<Author> author = session.createQuery("from Author", Author.class).getResultList();
    	session.close();
    	return author;
    }
    
    
}
