package com.eep.proyectoSpring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eep.proyectoSpring.models.component.UsuarioComp;
import com.eep.proyectoSpring.models.entity.Usuario;
import com.eep.proyectoSpring.models.sevice.IUsuarioService;

@Controller
@RequestMapping("/pelis")
public class UserController {
	@Autowired 
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private UsuarioComp usuarioPrincipal;
	
	public static final String INICIO_SESION = "inicioSesion";
	public static final String MENU = "menu";
	public static final String REGISTRAR_USUARIO = "registroUsr";

	private boolean correct = false;
	private boolean exist = false;
	@RequestMapping(value = "/inicioUsuario", method = RequestMethod.GET)
	public String iniciarUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("correcto", correct);
		exist=false;

		return INICIO_SESION; 

	}
	
	@RequestMapping(value = "/checkUsuario", method = RequestMethod.POST)
	public String checkUsuario(Model model,Usuario usuario) {
		List<Usuario>usuarios = new ArrayList<Usuario>();
		usuarios = serviceUsuario.findAll();
		for (Usuario us : usuarios) {	
			if (usuario.getEmail().equals(us.getEmail()) && usuario.getPassword().equals(us.getPassword())) {
				usuarioPrincipal.copia(us);
				System.out.println(us.getNombre() );
				Usuario usuario1 = new Usuario();
				usuario1 = serviceUsuario.findOne(usuarioPrincipal.getEmail());
				usuarioPrincipal.copia(usuario1);
				correct = true;	break;
			}else {correct = false;}	
		}
		if (correct) {
			
			//model.addAttribute("Usuario",usuario);
			return MENU;
		}else {
			model.addAttribute("correcto",correct);
			return "redirect:inicioUsuario"; 
		}
		
	}
	
	@RequestMapping(value = "/registroUsuario", method = RequestMethod.GET)
	public String crearFormularioUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("existe", exist);

		correct=true;
		return REGISTRAR_USUARIO; 

	}
	
	@RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
	public String altaUsuario(Model model,Usuario usuario) {
		Usuario usu= serviceUsuario.findOne(usuario.getEmail());
		if(usu==null) {
			serviceUsuario.save(usuario);exist=false;
		}else {
			exist=true;
		}
		if (exist) {
			model.addAttribute("correcto",correct);
			return "redirect:registroUsuario"; 
			
		}else {
			return "redirect:inicioUsuario";
		}
		
		
	}
	
}
