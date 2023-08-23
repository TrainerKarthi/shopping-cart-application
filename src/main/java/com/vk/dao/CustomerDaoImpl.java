package com.vk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vk.dto.Customer;
import com.vk.dto.Customer;

public class CustomerDaoImpl implements CustomerDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public Customer saveCustomer(Customer p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}

	public Customer findCustomerById(int id) {
		EntityManager em = emf.createEntityManager();
		Customer Customer = em.find(Customer.class, id);
		return Customer;
	}

	public List<Customer> findAllCustomers() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Customer p");
		List<Customer> list = query.getResultList();

		return list;
	}

	public boolean updateCustomerById(int id, Customer p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Customer customer = em.find(Customer.class, id);
		if (customer != null) {
			customer.setEmail(p.getEmail());
			customer.setName(p.getName());
			customer.setPassword(p.getPassword());
			customer.setPhone(p.getPhone());
			customer.setStatus(p.getStatus());

			et.begin();
			em.merge(customer);
			et.commit();
			return true;
		}

		return false;
	}

}
