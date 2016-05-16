/**
 * 
 */
package pt.caughtonnet.homee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author baia
 *
 */
@Entity
@Table(name = "SHOPPING_LIST", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class ShoppingList implements Serializable {
	private static final long serialVersionUID = -4834255133140966316L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String name;
	
	@ManyToOne
	private Home home;
	
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
	 * Gets the home
	 * @return the home
	 */
	public Home getHome() {
		return home;
	}
	
	/**
	 * Sets the home
	 * @param home the home to set
	 */
	public void setHome(Home home) {
		this.home = home;
	}

}
