package pt.caughtonnet.homee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author baia
 */
@Entity
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class User implements Serializable {
	private static final long serialVersionUID = 4735115875121877121L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column(unique = true)
	private String email;

	@Column
	private String password;
	
	@Column
	private Boolean confirmed;

	@Column
	private String confirmationHash;

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

}
