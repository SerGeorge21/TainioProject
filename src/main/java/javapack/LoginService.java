package javapack;

import org.springframework.stereotype.Service;

@Service	
public class LoginService {
	public boolean validateUser(String user_email, String user_password) throws Exception {
		
		Mysqlaccess my = new Mysqlaccess();
		return my.loginValidation(user_email,user_password);
	}
}

