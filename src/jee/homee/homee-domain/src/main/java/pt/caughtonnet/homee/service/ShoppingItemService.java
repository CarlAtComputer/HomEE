package pt.caughtonnet.homee.service;

import javax.ejb.Remote;

import pt.caughtonnet.homee.entity.ShoppingItem;

@Remote
public interface ShoppingItemService {
	public void createShoppingItem(Long shoppingListId, ShoppingItem create);
	public ShoppingItem getShoppingItemByName(String name);
}
