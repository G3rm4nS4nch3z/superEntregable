package com.eep.proyectoSpring.models.dao;

import java.util.List;

import com.eep.proyectoSpring.models.entity.Usuario;

public interface IUsuarioDao {
	
	public List<Usuario> findAll();
	
	public void save(Usuario cliente);

	Usuario findOne(String email);

}
