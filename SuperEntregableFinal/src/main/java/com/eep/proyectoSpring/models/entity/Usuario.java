package com.eep.proyectoSpring.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.web.context.annotation.SessionScope;

import com.eep.proyectoSpring.models.component.UsuarioComp;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	@Id
	private String email;
	private String nombre;	
	private String apellido;
	@Column(name = "contrasenia")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Pelicula> peliculas;

	
	public Usuario() {
		super();
		this.peliculas= new ArrayList<Pelicula>();

	}
	
	public void aniadirPelicula(Pelicula p) {
		this.peliculas.add(p);
	}
	
	public void copia(UsuarioComp us) {
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
