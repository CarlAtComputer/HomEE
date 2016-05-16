package pt.caughtonnet.homee.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pt.caughtonnet.homee.entity.ShoppingList;

@Local
@Stateless
@SuppressWarnings("unchecked")
public class ShoppingListDao {

	@PersistenceContext(unitName = "homee")
	private EntityManager em;

	public List<ShoppingList> getLastShoppingLists() {
		Query q = em.createQuery("select s from ShoppingList s order by s.id desc");
		return q.setMaxResults(5).getResultList();
	}

	public List<ShoppingList> getAllShoppingLists() {
		Query q = em.createQuery("select s from ShoppingList s order by s.id desc");
		return q.getResultList();
	}

	public void create(ShoppingList shoppingList) {
		em.persist(shoppingList);
	}

	public ShoppingList getShoppingListByName(String name) {
		try {
			TypedQuery<ShoppingList> q = em.createQuery("select s from ShoppingList s where s.name = :name", ShoppingList.class);
			q.setParameter("name", name);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
