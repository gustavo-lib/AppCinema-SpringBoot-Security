package com.gortiz.AppCinema.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gortiz.AppCinema.Serivices.IPelicula;


@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	IPelicula servicePelicula;
	
    
	@GetMapping({"/login", "/"})
	public String login() {
        return "login";
    }
	
	@GetMapping("/success")
	public ModelAndView index2() {
		ModelAndView model=new ModelAndView("default");
		model.addObject("list_pelicula", servicePelicula.getAllPelicula());
		return model;
        //return "default";
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
