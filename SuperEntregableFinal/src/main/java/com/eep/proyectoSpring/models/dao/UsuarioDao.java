package com.eep.proyectoSpring.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eep.proyectoSpring.models.entity.Pelicula;

import com.eep.proyectoSpring.models.entity.Usuario;
import com.eep.proyectoSpring.models.sevice.IPeliculaService;

@Repository
public class UsuarioDao implements IUsuarioDao{

	//El contexto de persistencia se refiere al "traductor" java/Mysql
		@PersistenceContext
		private EntityManager em;
		@Autowired
		IPeliculaService peliculaService;

		@Override
		@Transactional
		public void save(Usuario usuario) {

			if (findOne(usuario.getEmail())!=null) {
				if(usuario.getPeliculas()!=null && usuario.getPeliculas().size()>0) {
					for(Pelicula p:usuario.getPeliculas()) {
						peliculaService.save(p);
					}
				}
				//Al ya existir el id del cliente se entiende que estoy modificando uno antiguo y hago una "union"
				em.merge(usuario);
			} else {
				em.persist(usuario);
			}
		}
		
		@Override
		@Transactional(readOnly = true)
		public List<Usuario> findAll() {
			return em.createQuery("select u from Usuario u").getResultList();
		}
		
		@Override
		@Transactional(readOnly = true)
		public Usuario findOne(String email) {
			return em.find(Usuario.class, email);
		}

	

}
















