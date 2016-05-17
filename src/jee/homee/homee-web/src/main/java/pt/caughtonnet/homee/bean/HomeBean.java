package pt.caughtonnet.homee.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pt.caughtonnet.homee.entity.Home;

@SessionScoped
@ManagedBean(name = "home")
public class HomeBean {
	private Home active;
	
	public Home getActive() {
		return active;
	}
	
	public void setActive(Home active) {
		this.active = active;
	}
}
