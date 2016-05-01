/**
 * 
 */
package pt.caughtonnet.homee.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import pt.caughtonnet.homee.entity.User;
import pt.caughtonnet.homee.entity.UserRole;

/**
 * @author baia
 *
 */
@SuppressWarnings({ "unchecked" })
@Stateless
@Local
public class UserDao {
	private final static Logger logger = Logger.getLogger(UserDao.class.getName());
	public static final String SALT = "my-salt-text";

	@PersistenceContext(unitName = "homee")
	private EntityManager em;

	public List<User> getAll() {
		return em.createQuery("select u from User u").getResultList();
	}

	public User getById(Serializable id) {
		return em.find(User.class, id);
	}

	public User getByEmail(String email) {
		try {
			return em.createQuery("select u from User u where email = :email", User.class).setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * @param user
	 */
	public void save(User user) {
		try {
			em.persist(user);
		} catch (Exception e) {
			logger.error("Error generating password hash for user", e);
		}
	}

	public void updateUserRoles(User user, String[] roles) {
		UserRole userRole;
		String email = user.getEmail();
		user = null;
		em.createQuery("delete from UserRole where email = :email").setParameter("email", email).executeUpdate();
		for (String role : roles) {
			userRole = new UserRole();
			userRole.setEmail(email);
			userRole.setRole(role);
			em.persist(userRole);
		}
	}

}
