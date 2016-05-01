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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author baia
 *
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole implements Serializable {
	private static final long serialVersionUID = -7200212346082794369L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String email;
	
	@Column
	private String role;

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
	 * Gets the role
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
