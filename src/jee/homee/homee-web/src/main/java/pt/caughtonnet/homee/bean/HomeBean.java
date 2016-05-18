package pt.caughtonnet.homee.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.User;
import pt.caughtonnet.homee.service.HomeService;

@SessionScoped
@ManagedBean(name = "home")
public class HomeBean {
	private Home active;
	
	private Home create = new Home();

	@EJB(mappedName = "java:global/homee-service-ear/homee-service/homeService!pt.caughtonnet.homee.service.HomeService")
	private HomeService homeService;

	public Home getActive() {
		return active;
	}

	public void setActive(Home active) {
		this.active = active;
	}
	
	public Home getCreate() {
		create = new Home();
		return create;
	}
	
	public void setCreate(Home create) {
		this.create = create;
	}

	public List<Home> getUserHomes() {
		return homeService.getUserHomes(getLoggedUser());
	}

	public void createHome() {
		create.setUser(getLoggedUser());;
		homeService.createHome(create);
	}
	
	public String activateHome(Home home) {
		setActive(home);
		return "index";
	}
	
	private User getLoggedUser() {
		LoginBean login = (LoginBean) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), null, "login");
		return login.getLoggedUser();
	}

}
