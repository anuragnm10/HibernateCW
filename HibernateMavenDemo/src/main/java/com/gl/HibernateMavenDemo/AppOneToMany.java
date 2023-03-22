package com.gl.HibernateMavenDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateMavenDemo.config.HibernateConfig;
import com.gl.HibernateMavenDemo.entity.Product;
import com.gl.HibernateMavenDemo.entity.Store;

public class AppOneToMany {
	
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
	public static void main(String[] args) {
//		Store st = new Store();
//		st.setStoreId("D001");
//		st.setStoreName("Digital");
////		
//		Store st1 = new Store();
//		st1.setStoreId("S003");
//		st1.setStoreName("Sangeeta");
////		
//		Product p1 = new Product();
//		p1.setProdname("iPhone 14 Pro");
//		p1.setPdiscription("iPhone 14 Pro, deep purple, 128Gb Storage");
//		p1.setPrice(123000);
//		p1.setStore(st);
//		
//		Product p2 = new Product();
//		p2.setProdname("Logitech Wireless KeyBoard");
//		p2.setPdiscription("Wireless Mechanical keyboard with red switches");
//		p2.setPrice(20000);
//		p2.setStore(st);
//		
//		Product p3 = new Product();
//		p3.setPid(8);
//		p3.setProdname("Logitech Gaming Mouse");
//		p3.setPdiscription("Gaming mouse with 9 customizable buttons");
//		p3.setPrice(12500);
//		p3.setStore(st1);
//		
//		st.getProducts().add(p1);
//		st.getProducts().add(p2);
//		st.getProducts().add(p3);
//		System.out.println(insertProduct(p1));
//		System.out.println(insertProduct(p2));
//		System.out.println(insertProduct(p3));
		
//		int pid = 11;
//		List<Product> pds = getAllProducts(sid);
//		for(Product val : pds) {
//			System.out.println(val);
//		}
		String storeId = "S003";
		deleteStore(storeId);
	}
	
	public static String insertStore(Store store) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(store);
		tx.commit();
		session.close();
		return store.getStoreId();
	}
	
	public static int insertProduct(Product product) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(product);
		tx.commit();
		session.close();
		return product.getPid();
	}
	
	public static List<Product> getAllProducts(String sid){
		Session session = factory.openSession();
		Store store = session.get(Store.class, sid);
		List<Product> products = store.getProducts();
		session.close();
		return products;
	}
	
	public static Store getStore(int pid) {
		Session session = factory.openSession();
		Product product = session.get(Product.class, pid);
		Store store = product.getStore();
		session.close();
		return store;
	}
	
	public static void deleteStore(String storeID) {
		Session session = factory.openSession();
		Store store = session.get(Store.class, storeID);
		Transaction tx = session.beginTransaction();
		session.remove(store);
		tx.commit();
		session.close();
	}
	
	public static void deleteProduct(Product product) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.remove(product);
		tx.commit();
		session.close();
	}

}
