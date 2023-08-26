package com.vk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.vk.dto.Admin;
import com.vk.dto.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public Admin saveAdmin(Admin p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}

	public Admin findAdminById(int id) {
		EntityManager em = emf.createEntityManager();
		Admin Admin = em.find(Admin.class, id);
		return Admin;
	}

	public List<Admin> findAllAdmins() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Admin p");
		List<Admin> list = query.getResultList();

		return list;
	}

	public boolean updateAdminById(int id, Admin p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Admin admin = em.find(Admin.class, id);
		if (admin != null) {
			admin.setEmail(p.getEmail());
			admin.setName(p.getName());
			admin.setPassword(p.getPassword());

			et.begin();
			em.merge(admin);
			et.commit();
		}
		return false;
	}
	
	public boolean findByEmailAndPassword(String email , String password, HttpSession session) {
		EntityManager em = emf.createEntityManager() ;
		Query query = em.createQuery("select a from Admin a where a.email=?1 and a.password=?2") ;
		query.setParameter(1, email) ;
		query.setParameter(2, password) ;
		List<Admin> admin =  query.getResultList() ;
		if(admin.size()>0) {
			for(Admin a : admin) {
				session.setAttribute("admindetails", a);
			}
			return true ;
		}
		else {
			return false ;
		}
	}


}
