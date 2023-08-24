package com.vk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vk.dto.Merchant;
import com.vk.dto.Merchant;

public class MerchantDaoImpl implements MerchantDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public Merchant saveMerchant(Merchant p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}

	public Merchant findMerchantById(int id) {
		EntityManager em = emf.createEntityManager();
		Merchant Merchant = em.find(Merchant.class, id);
		return Merchant;
	}

	public List<Merchant> findAllMerchants() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Merchant p");
		List<Merchant> list = query.getResultList();

		return list;
	}

	public boolean updateMerchantById(int id, Merchant p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Merchant merchant = em.find(Merchant.class, id);

		if (merchant != null) {
			
			merchant.setName(p.getName());
			merchant.setEmail(p.getEmail());
			merchant.setName(p.getName());
			merchant.setMobile(p.getMobile());
			merchant.setStatus(p.getStatus());
			merchant.setPassword(p.getPassword());
			
			et.begin();
			em.merge(merchant);
			et.commit();
			return true;
		}
		return false;
	}

}
