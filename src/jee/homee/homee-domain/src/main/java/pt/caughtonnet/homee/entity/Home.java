/**
 * 
 */
package pt.caughtonnet.homee.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author baia
 *
 */
@Entity
@Table(name = "HOMES")
public class Home implements Serializable {
	private static final long serialVersionUID = -3259232339706502806L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;
	
	@OneToMany(mappedBy="home")
	private List<ShoppingList> shoopingLists;
	
	@ManyToOne
	private User user;

	/**
	 * Gets the id
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the shoopingLists
	 * @return the shoopingLists
	 */
	public List<ShoppingList> getShoopingLists() {
		return shoopingLists;
	}
	
	/**
	 * Sets the shoopingLists
	 * @param shoopingLists the shoopingLists to set
	 */
	public void setShoopingLists(List<ShoppingList> shoopingLists) {
		this.shoopingLists = shoopingLists;
	}
	
	public ShoppingList addShoopingList(ShoppingList shoppingList) {
		if (this.shoopingLists == null) {
			this.shoopingLists = new ArrayList<ShoppingList>();
		}
		shoppingList.setHome(this);
		this.shoopingLists.add(shoppingList);
		return shoppingList;
	}
	
	public ShoppingList removeShoopingList(ShoppingList shoopingList) {
		if (this.shoopingLists == null) {
			this.shoopingLists = new ArrayList<ShoppingList>();
		} else {
			shoopingList.setHome(null);
			this.shoopingLists.remove(shoopingList);
		}
		return shoopingList;
	}
	
	/**
	 * Gets the user
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Sets the user
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
