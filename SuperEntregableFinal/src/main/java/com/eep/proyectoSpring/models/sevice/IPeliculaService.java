package com.eep.proyectoSpring.models.sevice;

import java.util.List;

import com.eep.proyectoSpring.models.entity.Pelicula;

public interface IPeliculaService {
	
public List<Pelicula> findAll();

	public void save(Pelicula pelicula);

	public Pelicula findOne(String id);
		
}
