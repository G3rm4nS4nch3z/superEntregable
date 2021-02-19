package com.eep.proyectoSpring.models.sevice;

import java.util.List;

import com.eep.proyectoSpring.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();

	public void save(Usuario usuario);

	public Usuario findOne(String email);
	

	
}
