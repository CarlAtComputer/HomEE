package pt.caughtonnet.homee.service.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import pt.caughtonnet.homee.dao.ShoppingItemDao;
import pt.caughtonnet.homee.entity.ShoppingItem;
import pt.caughtonnet.homee.entity.ShoppingList;
import pt.caughtonnet.homee.service.ShoppingItemService;

@Stateless(name = "shoppingItemService")
public class ShoppingItemServiceBean implements ShoppingItemService {

	@EJB
	private ShoppingItemDao shoppingItemDao;
	
	@Override
	public void createShoppingItem(Long shoppingListId, ShoppingItem create) {
		shoppingItemDao.createShoppingItem(shoppingListId, create);
	}

	@Override
	public ShoppingItem getShoppingItemByName(String name) {
		return shoppingItemDao.getShoppingItemByName(name);
	}
}
