package com.vk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vk.dto.Item;
import com.vk.dto.Item;

public class ItemDaoImpl implements ItemDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public Item saveItem(Item p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}

	public Item findItemById(int id) {
		EntityManager em = emf.createEntityManager();
		Item Item = em.find(Item.class, id);
		return Item;
	}

	public List<Item> findAllItems() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Item p");
		List<Item> list = query.getResultList();

		return list;
	}

	public boolean updateItemById(int id, Item p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Item item = em.find(Item.class, id);
		
		if(item != null)
		{
			item.setCategory(p.getCategory());
			item.setPrice(p.getPrice());
			item.setProdId(p.getProdId());
			item.setQuantity(p.getQuantity());
			
			
			et.begin();
			em.merge(item);
			et.commit();
			return true;
		}
		return false;
	}

}
