package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
//
//	@Autowired
//	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		ArrayList<Customer> list = (ArrayList) session.createQuery("from Customer").list();

		session.getTransaction().commit();

		return list;

	}

	public void addCustomer(Customer newCustomer) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(newCustomer);
		session.getTransaction().commit();
	}

	public Customer getCustomer(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.getTransaction().commit();
		return customer;
	}

	public void updateCustomer(Customer customer) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		// begin transaction

		session.beginTransaction();
		session.update(customer);

		// commit transaction
		session.getTransaction().commit();

	}

	public void deleteCustomer(int id) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Customer where id="+ id).executeUpdate();
		session.getTransaction().commit();

	}

}
