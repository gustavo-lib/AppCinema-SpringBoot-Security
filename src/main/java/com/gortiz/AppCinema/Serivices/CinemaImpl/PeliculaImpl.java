package com.gortiz.AppCinema.Serivices.CinemaImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gortiz.AppCinema.Entity.Pelicula;
import com.gortiz.AppCinema.Repository.PeliculaRepository;
import com.gortiz.AppCinema.Serivices.IPelicula;

@Service("peliculaService")
public class PeliculaImpl implements IPelicula{
	
	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public Pelicula save(Pelicula p) {
		peliculaRepository.save(p);
		return p;
	}

	@Override
	public List<Pelicula> getAllPelicula() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula getPeliculaById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePeliculaById(long id) {
		// TODO Auto-generated method stub
		
	}
	

}
