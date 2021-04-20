package com.gortiz.AppCinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gortiz.AppCinema.Entity.Pelicula;

@Repository("PeliculaRepository")
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
