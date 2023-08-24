package com.vk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vk.dto.Product;

public class ProductDaoImpl implements ProductDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public Product saveProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}

	public Product findProductById(int id) {
		EntityManager em = emf.createEntityManager();
		Product product = em.find(Product.class, id);
		return product;
	}

	public List<Product> findAllProducts() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Product p");
		List<Product> list = query.getResultList();

		return list;
	}

	public boolean updateProductById(int id, Product p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Product product = em.find(Product.class, id);

		if (product != null) {
			product.setCategory(p.getCategory());
			product.setImg(p.getImg());
			product.setMerchant(p.getMerchant());
			product.setName(p.getName());
			product.setPrice(p.getPrice());
			product.setStock(p.getStock());
			et.begin();
			em.merge(product);
			et.commit();
			return true;
		}
		return false;
	}

}
