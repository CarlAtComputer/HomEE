/**
 * 
 */
package pt.caughtonnet.homee.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import pt.caughtonnet.homee.entity.User;
import pt.caughtonnet.homee.service.exception.UserAlreadyExistsException;

/**
 * @author baia
 */

@Remote
public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(Serializable id);
	public User getUserByEmail(String email);
	public User registerUser(User user) throws UserAlreadyExistsException;
}
