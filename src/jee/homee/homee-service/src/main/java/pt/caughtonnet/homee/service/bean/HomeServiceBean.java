package pt.caughtonnet.homee.service.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.caughtonnet.homee.dao.HomeDao;
import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.User;
import pt.caughtonnet.homee.service.HomeService;

@Stateless(name = "homeService")
public class HomeServiceBean implements HomeService {

	@EJB
	private HomeDao homeDao;
	
	@Override
	public List<Home> getUserHomes(User user) {
		return homeDao.getUserHomes(user);
	}

	@Override
	public Home createHome(Home home) {
		return homeDao.createHome(home);
	}

}
