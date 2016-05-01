/**
 * 
 */
package pt.caughtonnet.homee.service.exception;

import pt.caughtonnet.homee.entity.User;

/**
 * @author baia
 *
 */
public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = -1127213956647940136L;
	private User user;

	public UserAlreadyExistsException(User user) {
		this(null, null, user);
	}
	
	public UserAlreadyExistsException(String message, User user) {
		this(message, null, user);
	}
	
	public UserAlreadyExistsException(String message, Exception e, User user) {
		super(message, e);
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
