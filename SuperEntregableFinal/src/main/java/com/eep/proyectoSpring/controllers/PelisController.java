package com.eep.proyectoSpring.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eep.proyectoSpring.models.component.PeliculaComp;
import com.eep.proyectoSpring.models.component.UsuarioComp;
import com.eep.proyectoSpring.models.entity.Pelicula;
import com.eep.proyectoSpring.models.entity.Usuario;
import com.eep.proyectoSpring.models.sevice.IPeliculaService;
import com.eep.proyectoSpring.models.sevice.IUsuarioService;
import com.eep.proyectoSpring.models.sevice.PeticionGetExterna;
import com.google.gson.Gson;

@Controller
@RequestMapping("/pelis")
public class PelisController {

	@Autowired 
	private IUsuarioService serviceUsuario;
	@Autowired
	private Gson gson;
	@Autowired
	private PeticionGetExterna peticion;
	
	@Autowired 
	private IPeliculaService servicePelicula;
	
	@Autowired
	private PeliculaComp peliculaSeleccionada;
	
	@Autowired
	private UsuarioComp usuarioPrincipal;
	
	private boolean menu =false;
	private boolean tabla =false;
	private boolean repe=false;

	public static final String REALIZAR_BUSQUEDA = "buscarPeli";
	public static final String LISTAR_PELIS = "listarPelis";

	public static final String MENU = "menu";

	
	@RequestMapping(value = "/busquedaPelis", method = RequestMethod.GET)
	public String buscarPeli(Model model) {
		Pelicula peli = new Pelicula();
		model.addAttribute("usuario", usuarioPrincipal);
		model.addAttribute("pelicula", peli);
		model.addAttribute("menu", menu);
		model.addAttribute("repe",repe);
		System.out.println(repe);

		System.out.println(usuarioPrincipal.getNombre());
		return REALIZAR_BUSQUEDA; 

	} 
	
	@RequestMapping(value = "/mostrarPeli", method = RequestMethod.GET)
	public String mostrarPeli (Model model, Pelicula peli) throws IOException {
		System.out.println(peli.getTitulo());
		
		if(peli.getTitulo()==null) {
			tabla =false;
			return "menu";
		}else if(peli.getTitulo()=="") {tabla =false;return "redirect:busquedaPelis"; }
		else{
			String busqueda="http://www.omdbapi.com/?apikey=9d38ce55";
			if (peli.getTitulo().contains(" ")) {
				peli.setTitulo(peli.getTitulo().replace(' ', '+'));
	        }
			busqueda+="&t=" + peli.getTitulo();
			String texto= peticion.sendGET(busqueda);
			System.out.println(texto);
			//Una vez obtengo la respuesta en JSON lo transformo en un objeto de tipo MOVIE
			//GSON es una librería para transformar Json a objetos y al revés.
			//Para utilizarla hay que pasarle el texto(json) y el tipo de objeto al que queremos transformarlo
			
		    Pelicula pelicula = gson.fromJson(texto, Pelicula.class);
		    System.out.println(pelicula.toString());

		    //Hago la traduccion entre peliculacomp y pelicula
		    peliculaSeleccionada.copia(pelicula);
		    tabla =true;
		    peli.setTitulo("");
		    model.addAttribute("usuario", usuarioPrincipal);
		    model.addAttribute("pelicula", peli);
		    model.addAttribute("resultado", peliculaSeleccionada);
		    model.addAttribute("tabla", tabla);
		  
			return REALIZAR_BUSQUEDA;
		}


	}
	@RequestMapping(value = "/guardarPeli", method = RequestMethod.GET)
	public String guardarPeli (Model model) {
		
		Usuario usuario = new Usuario();
		Pelicula peli = new Pelicula();
		peli.copia(peliculaSeleccionada);
		System.out.println("++++"+ peliculaSeleccionada.toString());
		servicePelicula.save(peli);
		//peli = servicePelicula.findOne(peliculaSeleccionada.getIdPeli());
		System.out.println("jjjjj"+peliculaSeleccionada.toString());
		repe=false;
		if(usuarioPrincipal.getPeliculas().size()>0) {
			for (Pelicula peliUs : usuarioPrincipal.getPeliculas()) {
				if (peliUs.getIdPeli().equals(peliculaSeleccionada.getIdPeli())){
					repe=true;
				}
			}	
		}
		if (!repe) {usuarioPrincipal.aniadirPelicula(peli);}
		usuario.copia(usuarioPrincipal);
		System.out.println(usuario.toString());
		serviceUsuario.save(usuario);
		tabla =false;
		return "redirect:busquedaPelis"; 

	}
	@RequestMapping(value = "/listarPelis", method = RequestMethod.GET)
	public String listarPelis (Model model) {
		Usuario us = new Usuario();
		us = serviceUsuario.findOne(usuarioPrincipal.getEmail());
		System.out.println(us.toString());
		usuarioPrincipal.copia(us);
		model.addAttribute("usuario", usuarioPrincipal);
		return LISTAR_PELIS; 

	}

}

