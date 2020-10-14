package javapack;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;




@Controller
public class LoginController {
	
	LoginService service = new LoginService();
	boolean isUserAuthenticated = false;

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String showLoginPage() {
		isUserAuthenticated = false;
		return "login";
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)//changed /login to /welcome
	public String handleLoginRequest(@RequestParam String user_email,@RequestParam String user_password, ModelMap model) throws Exception {
		if(!service.validateUser(user_email,user_password)) {
			model.put("errorMessage","There was an error with your E-Mail/Password combination. Please try again.");
			return "login";
		}
		model.put("user_email",user_email);
		isUserAuthenticated =true;
		return "welcome";
		
	}
	
	

	
	
	
	
	

	
	
} 