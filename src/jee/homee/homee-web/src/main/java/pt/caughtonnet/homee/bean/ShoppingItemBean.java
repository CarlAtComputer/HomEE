package pt.caughtonnet.homee.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.AssertTrue;

import pt.caughtonnet.homee.entity.ShoppingItem;
import pt.caughtonnet.homee.service.ShoppingItemService;

@ViewScoped
@ManagedBean(name = "shoppingItem")
public class ShoppingItemBean {

	private ShoppingItem create;
	
	private Long shoppingListId;
	
	@EJB(mappedName="java:global/homee-service-ear/homee-service/shoppingItemService!pt.caughtonnet.homee.service.ShoppingItemService")
	private ShoppingItemService shoppingItemService;
	
	@PostConstruct
    public void initialize() {
		create = new ShoppingItem();
	}
	
	public ShoppingItem getCreate() {
		return create;
	}
	
	public void setCreate(ShoppingItem create) {
		this.create = create;
	}

	public Long getShoppingListId() {
		return shoppingListId;
	}
	
	public void setShoppingListId(Long shoppingListId) {
		this.shoppingListId = shoppingListId;
	}
	
	@AssertTrue(message = "There is a shopping item already with that name")
	public boolean isNewShoppingItemEquals() {
		return shoppingItemService.getShoppingItemByName(create.getName()) == null;
	}
	
	public String createShoppingItem() {
		shoppingItemService.createShoppingItem(shoppingListId, create);
		return "/app/shopping/shopping-list.xhtml?faces-redirect=true&shopping-list-id="+shoppingListId;
	}
}
