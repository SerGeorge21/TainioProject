package javapack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookmarkController {
	Mysqlaccess my = new Mysqlaccess();
	
	
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String hitSaveButton(@RequestParam String id, @RequestParam String user_email, ModelMap model) throws Exception {
		my.bookmarkMovie(user_email,id);
		model.put("user_email",user_email);
		return "welcome";
	}
	
	@RequestMapping(value ="/My_Bookmarks",method = RequestMethod.POST)
	public String showBookmarkPage(@RequestParam String user_email, ModelMap model) throws Exception {
		String id = my.getBookmarks(user_email);
		model.put("id_from_controller",id);
		return "bookmarks";
	}
	
	
	
	
	
}


