package com.eep.proyectoSpring.models.sevice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eep.proyectoSpring.models.dao.IPeliculaDao;
import com.eep.proyectoSpring.models.entity.Pelicula;
@Service
public class PeliculaServiceImpl implements IPeliculaService {

		@Autowired
		private IPeliculaDao peliDao;
		
	   @Override
	    @Transactional(readOnly = true)
	    public List<Pelicula> findAll() {
	        // TODO Auto-generated method stub
	        return peliDao.findAll();
	    }

	    @Override
	    @Transactional
	    public void save(Pelicula peli) {
	        peliDao.save(peli);

	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Pelicula findOne(String id) {
	        return peliDao.findOne(id);
	    }

}
