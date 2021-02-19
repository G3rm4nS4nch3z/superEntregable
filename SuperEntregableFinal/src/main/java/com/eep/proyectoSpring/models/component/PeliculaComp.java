package com.eep.proyectoSpring.models.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.eep.proyectoSpring.models.entity.Pelicula;

@SessionScope
@Component
	public class PeliculaComp {
		
	private String idPeli;
	private String titulo;
	private String director;
	private String year;	
	private String duracion;
	private String poster;
		
	
		
		public PeliculaComp() {
		super();
		}

		public PeliculaComp(String idPeli, String titulo, String director, String year, String duracion, String poster) {
			super();
			this.idPeli = idPeli;
			this.titulo = titulo;
			this.director = director;
			this.year = year;
			this.duracion = duracion;
			this.poster = poster;
		}

		public void copia(Pelicula p2) {
			this.director=p2.getDirector();
			this.idPeli=p2.getIdPeli();
			this.poster=p2.getPoster();
			this.duracion=p2.getDuracion();
			this.titulo=p2.getTitulo();
			this.year=p2.getYear();
		}

		@Override
		public String toString() {
			return "PeliculaComp [idPeli=" + idPeli + ", titulo=" + titulo + ", director=" + director + ", year=" + year
					+ ", duracion=" + duracion + ", poster=" + poster + "]";
		}
		public String getIdPeli() {
			return idPeli;
		}

		public void setIdPeli(String idPeli) {
			this.idPeli = idPeli;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getDuracion() {
			return duracion;
		}

		public void setDuracion(String duracion) {
			this.duracion = duracion;
		}

		public String getPoster() {
			return poster;
		}

		public void setPoster(String poster) {
			this.poster = poster;
		}
		
		

}