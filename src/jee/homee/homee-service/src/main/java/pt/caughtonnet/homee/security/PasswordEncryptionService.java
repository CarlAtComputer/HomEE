package pt.caughtonnet.homee.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PasswordEncryptionService {

	public String getEncryptedPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(password.getBytes());
		byte[] digest = sha.digest();
		return new String(Base64.getEncoder().encode(digest));
	}

	public byte[] generateSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		return salt;
	}
}