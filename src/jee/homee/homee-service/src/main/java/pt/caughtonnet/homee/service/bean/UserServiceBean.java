/**
 * 
 */
package pt.caughtonnet.homee.service.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import pt.caughtonnet.homee.dao.UserDao;
import pt.caughtonnet.homee.entity.User;
import pt.caughtonnet.homee.security.PasswordEncryptionService;
import pt.caughtonnet.homee.service.UserService;
import pt.caughtonnet.homee.service.exception.UserAlreadyExistsException;

/**
 * @author baia
 *
 */
@Stateless(name="userService")
public class UserServiceBean implements UserService {
	private final static Logger logger = Logger.getLogger(UserServiceBean.class.getName());

	@Inject
	private PasswordEncryptionService passEncrypt;

	@EJB
	private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.homee.service.UserService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.homee.service.UserService#getUserById(java.io.Serializable)
	 */
	@Override
	public User getUserById(Serializable id) {
		return userDao.getById(id);
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.homee.service.UserService#getUserByEmail(java.lang.String)
	 */
	@Override
	public User getUserByEmail(String email) {
		return userDao.getByEmail(email);
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.homee.service.UserService#registerUser(pt.caughtonnet.homee.entity.User)
	 */
	@Override
	public User registerUser(User userToRegister) throws UserAlreadyExistsException {
		if (userDao.getByEmail(userToRegister.getEmail()) != null) {
			throw new UserAlreadyExistsException(userToRegister);
		}

		try {
			userToRegister.setPassword(passEncrypt.getEncryptedPasswordHash(userToRegister.getPassword()));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			logger.error("Error generating password hash for user", e);
			return null;
		}

		try {
			userToRegister.setConfirmed(false);
			userToRegister.setConfirmationHash(passEncrypt.getEncryptedPasswordHash(userToRegister.getEmail()));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			logger.error("Error generating the confirmation hash for user", e);
			return null;
		}
		
		try {
			userDao.save(userToRegister);
		} catch (Exception e) {
			logger.debug("Invalid user to register", e);
			return null;
		}

		try {
			userDao.updateUserRoles(userToRegister, new String[] { "ADMIN", "USER" });
		} catch (Exception e) {
			logger.error("Invalid user roles to register", e);
			return null;
		}
		return userToRegister;
	}

}
