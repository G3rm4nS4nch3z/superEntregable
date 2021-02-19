package com.eep.proyectoSpring.models.dao;

import java.util.List;

import com.eep.proyectoSpring.models.entity.Pelicula;

public interface IPeliculaDao {
	
	public List<Pelicula> findAll();
	
	public void save(Pelicula pelicula);

	Pelicula findOne(String email);

}
