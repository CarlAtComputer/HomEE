package pt.caughtonnet.homee.service;

import java.util.List;

import javax.ejb.Remote;

import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.ShoppingList;

@Remote
public interface ShoppingListService {
	public List<ShoppingList> getAllShoppingLists(Home home);
	public List<ShoppingList> getLastShoppingLists(Home home);
	public void createNewShoppingList(ShoppingList shoppingList);
	public ShoppingList getShoppingListByName(String name);
	public ShoppingList getShoppingListById(Long shoppingListId);
}
