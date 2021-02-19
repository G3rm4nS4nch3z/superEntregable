package com.eep.proyectoSpring.models.component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.eep.proyectoSpring.models.entity.Pelicula;
import com.eep.proyectoSpring.models.entity.Usuario;

@SessionScope
@Component
public class UsuarioComp {

	private String email;
	private String nombre;	
	private String apellido;
	private String password;
	private List<Pelicula> peliculas;

	public UsuarioComp() {
		super();
		this.peliculas= new ArrayList<Pelicula>();

	}

	public void aniadirPelicula(Pelicula p) {
		this.peliculas.add(p);
	}

	public void copia(Usuario us) {
		this.email = us.getEmail();
		this.nombre = us.getNombre();
		this.apellido = us.getApellido();
		this.password = us.getApellido();
		this.peliculas = us.getPeliculas();
		
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password
				+ ", peliculas=" + peliculas + "]";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
}
