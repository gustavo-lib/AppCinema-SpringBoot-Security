package com.gortiz.AppCinema.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listapelicula")
	String listapelicula() {
		return "lista_admin";
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/formpelicula")
	String pelicula() {
		return "formpeli";
	}
	
}
