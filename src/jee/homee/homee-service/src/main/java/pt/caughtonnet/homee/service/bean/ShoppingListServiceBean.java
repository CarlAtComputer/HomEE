package pt.caughtonnet.homee.service.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.caughtonnet.homee.dao.ShoppingListDao;
import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.ShoppingList;
import pt.caughtonnet.homee.service.ShoppingListService;

@Stateless(name = "shoppingListService")
public class ShoppingListServiceBean implements ShoppingListService {

	@EJB
	private ShoppingListDao shoppingListDao;

	@Override
	public List<ShoppingList> getLastShoppingLists(Home home) {
		return shoppingListDao.getLastShoppingLists(home);
	}
	
	@Override
	public List<ShoppingList> getAllShoppingLists(Home home) {
		return shoppingListDao.getAllShoppingLists(home);
	}

	@Override
	public void createNewShoppingList(ShoppingList shoppingList) {
		shoppingListDao.create(shoppingList);
	}

	@Override
	public ShoppingList getShoppingListByName(String name) {
		return shoppingListDao.getShoppingListByName(name);
	}

}
