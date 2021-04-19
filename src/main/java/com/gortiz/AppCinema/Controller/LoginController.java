package com.gortiz.AppCinema.Controller;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class LoginController {
	
    
	@GetMapping({"/login", "/"})
	public String login() {
        return "login";
    }
	
	@GetMapping("/success")
	public String index2() {
        return "default";
    }
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String index_admin() {
        return "admin";
    }
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user")
	public String index_user() {
        return "user";
    }
    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }
    
    /*@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/formpelicula")
	String pelicula() {
		return "formpeli";
	}*/
}
