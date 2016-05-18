package pt.caughtonnet.homee.service;

import java.util.List;
import javax.ejb.Remote;
import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.User;

@Remote
public interface HomeService {
	public List<Home> getUserHomes(User user);
	public Home createHome(Home home);
}
