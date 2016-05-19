package pt.caughtonnet.homee.dao;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.caughtonnet.homee.entity.ShoppingItem;

@Local
@Stateless
@SuppressWarnings("unchecked")
public class ShoppingItemDao {
	
	@EJB
	private ShoppingListDao shoppingListDao;
	
	@PersistenceContext(unitName = "homee")
	private EntityManager em;

	public ShoppingItem createShoppingItem(Long shoppingListId, ShoppingItem create) {
		create.setShoppingList(shoppingListDao.getShoppingListById(shoppingListId));
		em.persist(create);
		return create;
	}

	public ShoppingItem getShoppingItemByName(String name) {
		try {
			TypedQuery<ShoppingItem> q = em.createQuery("select i from ShoppingItem i where i.name = :name", ShoppingItem.class);
			q.setParameter("name", name);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
