package bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String Login() {
		
		return "fancy-login";	
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		
		return "access-denied";
	}
	
	/*@PostMapping("getLogin")
	public ModelAndView getLogin(@PathVariable String userName, String password) {
		
		// get logged in user info and retieve info from db
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject(modelAndView);
	
		return modelAndView;
		
	}
	
	*/
}
