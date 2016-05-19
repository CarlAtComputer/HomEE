package pt.caughtonnet.homee.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pt.caughtonnet.homee.entity.ShoppingList;
import pt.caughtonnet.homee.service.ShoppingListService;

@ViewScoped
@ManagedBean(name = "shoppingDetail")
public class ShoppingDetailBean {
	
	@EJB(mappedName="java:global/homee-service-ear/homee-service/shoppingListService!pt.caughtonnet.homee.service.ShoppingListService")
	private ShoppingListService shoppingListService;
	
	private Long shoppingListId;

	private ShoppingList shoppingList;
	
	public void setShoppingListId(Long shoppingListId) {
		this.shoppingListId = shoppingListId;
	}
	
	public Long getShoppingListId() {
		return shoppingListId;
	}
	
	public ShoppingList getShoppingList() {
		if (shoppingList == null) {
			shoppingList = shoppingListService.getShoppingListById(shoppingListId);
		}
		return shoppingList;
	}
}
