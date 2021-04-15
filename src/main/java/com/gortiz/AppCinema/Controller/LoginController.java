package com.gortiz.AppCinema.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
    
	@GetMapping({"/login", "/"})
	public String login() {
        return "login";
    }
	
	@GetMapping("/welcome")
	public String index() {
        return "welcome";
    }

}
