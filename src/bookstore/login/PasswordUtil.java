package bookstore.login;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {

	// salt 생성
	public static String generateSalt() {
		byte[] salt = new byte[16];
		new SecureRandom().nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}

	// SHA-256 + salt 해시 처리
	public static String hashPassword(String password, String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(Base64.getDecoder().decode(salt)); // salt 추가
			byte[] hashed = md.digest(password.getBytes("UTF-8"));
			return Base64.getEncoder().encodeToString(hashed);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}