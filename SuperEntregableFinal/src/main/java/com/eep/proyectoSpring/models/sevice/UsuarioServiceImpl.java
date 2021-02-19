package com.eep.proyectoSpring.models.sevice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eep.proyectoSpring.models.dao.IUsuarioDao;
import com.eep.proyectoSpring.models.entity.Usuario;
@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	public Usuario findOne(String email) {
		// TODO Auto-generated method stub
		return usuarioDao.findOne(email);
	}

}
