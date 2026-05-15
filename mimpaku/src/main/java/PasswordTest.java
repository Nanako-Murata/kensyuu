import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("password123");
		System.out.println(password);
	}

}
