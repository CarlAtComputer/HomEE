/**
 * 
 */
package pt.caughtonnet.homee.bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.User;
import pt.caughtonnet.homee.service.UserService;

@SessionScoped
@ManagedBean(name="register")
public class RegisterBean {
	private String name = "test";
	private String email = "test";
	private String password = "test";

	@EJB(mappedName="java:global/homee-service-ear/homee-service/userService!pt.caughtonnet.homee.service.UserService")
	private UserService userService;

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
	 * Register action
	 */
	public void register() {
		User userToRegister = new User();
		userToRegister.setName(name);
		userToRegister.setEmail(email);
		userToRegister.setPassword(password);
		userToRegister.setHomes(new ArrayList<Home>());
		Home defaultHome = createDefaultHome(userToRegister);
		userToRegister.getHomes().add(defaultHome);
		userToRegister.setDefaultHome(defaultHome);
		
		try {
			userService.registerUser(userToRegister);
		} catch (Exception e) {
			try {
				e.printStackTrace();
				String msg = "Email already registered";
				FacesContext.getCurrentInstance().addMessage("registerForm:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.getFlash().setKeepMessages(true);
				ec.redirect("index.xhtml#register");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	
	

	private Home createDefaultHome(User userToRegister) {
		Home home = new Home();
		home.setName(userToRegister.getName() + "'s home");
		home.setUser(userToRegister);
		return home;
	}

}
