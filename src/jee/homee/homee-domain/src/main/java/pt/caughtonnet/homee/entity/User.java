package pt.caughtonnet.homee.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author baia
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 4735115875121877121L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;
	
	@Column
	private Boolean confirmed;

	@Column
	private String confirmationHash;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Home> homes;
	
	@OneToOne
	private Home defaultHome;

	/**
	 * Gets the id
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id
	 * 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the confirmed
	 * @return the confirmed
	 */
	public Boolean getConfirmed() {
		return confirmed;
	}
	
	/**
	 * Sets the confirmed
	 * @param confirmed the confirmed to set
	 */
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	/**
	 * Gets the confirmationHash
	 * @return the confirmationHash
	 */
	public String getConfirmationHash() {
		return confirmationHash;
	}
	
	/**
	 * Sets the confirmationHash
	 * @param confirmationHash the confirmationHash to set
	 */
	public void setConfirmationHash(String confirmationHash) {
		this.confirmationHash = confirmationHash;
	}
	
	/**
	 * Gets the homes
	 * @return the homes
	 */
	public List<Home> getHomes() {
		return homes;
	}
	
	/**
	 * Sets the homes
	 * @param homes the homes to set
	 */
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	
	public Home addHome(Home home) {
		if (homes == null) {
			homes = new ArrayList<Home>();
		}
		home.setUser(this);
		homes.add(home);
		return home;
	}
	
	public Home removeHome(Home home) {
		if (homes == null) {
			homes = new ArrayList<Home>();
		}
		home.setUser(null);
		homes.remove(home);
		return home;
	}
	
	public Home getDefaultHome() {
		return defaultHome;
	}
	
	public void setDefaultHome(Home defaultHome) {
		this.defaultHome = defaultHome;
	}

}
