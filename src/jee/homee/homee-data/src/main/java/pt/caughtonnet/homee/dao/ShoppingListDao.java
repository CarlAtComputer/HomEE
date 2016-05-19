package pt.caughtonnet.homee.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.ShoppingList;

@Local
@Stateless
@SuppressWarnings("unchecked")
public class ShoppingListDao {

	@PersistenceContext(unitName = "homee")
	private EntityManager em;

	public List<ShoppingList> getLastShoppingLists(Home home) {
		Query q = em.createQuery("select s from ShoppingList s where s.home = :home order by s.id desc");
		q.setParameter("home", home);
		return q.setMaxResults(5).getResultList();
	}

	public List<ShoppingList> getAllShoppingLists(Home home) {
		Query q = em.createQuery("select s from ShoppingList s where s.home = :home order by s.id desc");
		q.setParameter("home", home);
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

	public ShoppingList getShoppingListById(Long shoppingListId) {
		try {
			TypedQuery<ShoppingList> q = em.createQuery("select s from ShoppingList s left join FETCH s.shoppingItems i where s.id = :id", ShoppingList.class);
			q.setParameter("id", shoppingListId);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
