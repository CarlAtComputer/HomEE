/**
 * 
 */
package pt.caughtonnet.homee.bean;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import pt.caughtonnet.homee.entity.User;
import pt.caughtonnet.homee.service.UserService;

/**
 * @author baia
 *
 */
@SessionScoped
@ManagedBean(name = "login")
@DeclareRoles("ADMIN")
public class LoginBean {
	private String email;
	private String password;
	private User loggedUser;

	@EJB(mappedName="java:global/homee-service-ear/homee-service/userService!pt.caughtonnet.homee.service.UserService")
	private UserService userService;
	
	@ManagedProperty("#{home}")
	private HomeBean homeBean;

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
	 * Gets the loggedUser
	 * @return the loggedUser
	 */
	public User getLoggedUser() {
		return loggedUser;
	}
	
	/**
	 * Sets the loggedUser
	 * @param loggedUser the loggedUser to set
	 */
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	public void setHomeBean(HomeBean homeBean) {
		this.homeBean = homeBean;
	}
	
	public HomeBean getHomeBean() {
		return homeBean;
	}

	public String login() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		try {
			request.login(email, password);
			loggedUser = userService.getUserByEmail(email);
			homeBean.setActive(loggedUser.getDefaultHome());
			return "/app/index";
		} catch (ServletException e) {
			try {
				String msg = "Invalid email and/or password";
				FacesContext.getCurrentInstance().addMessage("loginForm:password", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
				ec.getFlash().setKeepMessages(true);
				ec.redirect("index.xhtml#login");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return null;
		}
	}
	
	public void logout() {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) ec.getRequest();
			request.logout();
			loggedUser = null;
			ec.redirect("index.xhtml#login");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
