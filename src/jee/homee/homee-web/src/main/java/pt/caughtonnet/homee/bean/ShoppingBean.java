package pt.caughtonnet.homee.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.AssertTrue;

import pt.caughtonnet.homee.entity.ShoppingList;
import pt.caughtonnet.homee.service.ShoppingListService;

@ViewScoped
@ManagedBean(name = "shopping")
public class ShoppingBean {

	@EJB(mappedName="java:global/homee-service-ear/homee-service/shoppingListService!pt.caughtonnet.homee.service.ShoppingListService")
	private ShoppingListService shoppingListService;

	private ShoppingList newShoppingList = new ShoppingList();
	
	public List<ShoppingList> getLastShoppingLists() {
		return shoppingListService.getLastShoppingLists();
	}
	
	public List<ShoppingList> getShoppingLists() {
		return shoppingListService.getAllShoppingLists();
	}
	
	public ShoppingList getNewShoppingList() {
		return newShoppingList;
	}
	
	public void setNewShoppingList(ShoppingList newShoppingList) {
		this.newShoppingList = newShoppingList;
	}
	
	@AssertTrue(message = "There is a shopping list already with that name")
	public boolean isNewShoppingListEquals() {
		return shoppingListService.getShoppingListByName(newShoppingList.getName()) == null;
	}
	
	public String createNewShoppingList() {
		try {
			shoppingListService.createNewShoppingList(this.newShoppingList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/app/shopping.xhtml";
	}
	
}
