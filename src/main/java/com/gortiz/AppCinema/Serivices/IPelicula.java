package com.gortiz.AppCinema.Serivices;

import java.util.List;

import com.gortiz.AppCinema.Entity.Pelicula;

public interface IPelicula {
	
	Pelicula save(Pelicula p);
	
	List<Pelicula> getAllPelicula();
	
	Pelicula getPeliculaById(Integer id);
	
	void deletePeliculaById(long id);
	

}
