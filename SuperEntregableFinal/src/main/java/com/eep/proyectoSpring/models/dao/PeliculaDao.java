package com.eep.proyectoSpring.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.eep.proyectoSpring.models.entity.Pelicula;


@Repository
public class PeliculaDao implements IPeliculaDao{

	//El contexto de persistencia se refiere al "traductor" java/Mysql
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(Pelicula peli) {

		if (findOne(peli.getIdPeli())!=null) {
			em.merge(peli);
		} else {
			em.persist(peli);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> findAll() {
		return em.createQuery("select p from Peliculas p").getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Pelicula findOne(String id) {
		return em.find(Pelicula.class, id);
	}

}
















