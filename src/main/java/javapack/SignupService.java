package javapack;

import org.springframework.stereotype.Service;

@Service
public class SignupService {
	public boolean validateSignUp(String user, String password) throws Exception {
		Mysqlaccess my = new Mysqlaccess();
		return my.signUpValidation(user, password);
	}
}

