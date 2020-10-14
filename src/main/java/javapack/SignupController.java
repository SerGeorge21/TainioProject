package javapack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
	SignupService service = new SignupService();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String user_email, @RequestParam String user_password,
			@RequestParam String passconfirm, ModelMap model) throws Exception {

		if (!user_password.equals(passconfirm)) {
			model.put("errorMessage", "Passwords dont match, try again later");
			return "register";
		}

		if (!service.validateSignUp(user_email, user_password)) {
			model.put("errorMessage", "There is already a user with this email.");
			return "register";
		}
		model.put("user_email", user_email);
		return "welcome";

	}
}
