package pt.caughtonnet.homee.service;

import java.util.List;

import javax.ejb.Remote;

import pt.caughtonnet.homee.entity.ShoppingList;

@Remote
public interface ShoppingListService {
	public List<ShoppingList> getAllShoppingLists();
	public List<ShoppingList> getLastShoppingLists();
	public void createNewShoppingList(ShoppingList shoppingList);
	public ShoppingList getShoppingListByName(String name);
}
