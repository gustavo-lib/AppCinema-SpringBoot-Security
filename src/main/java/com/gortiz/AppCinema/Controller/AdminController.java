package com.gortiz.AppCinema.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gortiz.AppCinema.Entity.Pelicula;
import com.gortiz.AppCinema.Serivices.IPelicula;

@Controller
public class AdminController {
	
	
	@Autowired
	IPelicula servicePelicula;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listapelicula")
	String listapelicula() {
		
		return "lista_admin";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/formpelicula")
	String pelicula(Model model) {
		Pelicula pelicula = new Pelicula();
		pelicula.setCalificacion(null);
		pelicula.setPersonajes(null);
		pelicula.setPaisDeOrigen(null);
		pelicula.setFunciones(null);
		model.addAttribute("pelicula", pelicula);
		return "formpeli";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/guardar")
	String guardar_pelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		String nombre=pelicula.getCalificacion().getNombre();
		pelicula.getCalificacion().setId(4);
		if (nombre.equals("Exelente")) {
			pelicula.getCalificacion().setId(1);
		}
		if (nombre.equals("Muy Buena")) {
			pelicula.getCalificacion().setId(2);
		}
		
		if (nombre.equals("Buena")) {
			pelicula.getCalificacion().setId(3);
		}
		servicePelicula.save(pelicula);
		
		return "redirect:/success";
	}

	
	
	
	
}
