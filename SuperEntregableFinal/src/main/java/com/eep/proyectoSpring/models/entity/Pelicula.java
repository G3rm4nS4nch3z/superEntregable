package com.eep.proyectoSpring.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.eep.proyectoSpring.models.component.PeliculaComp;

	@Entity
	@Table(name = "peliculas")
	public class Pelicula {
		
		@Id
		@Column(name = "id")
		private String imdbID;
		
		private String Title;	
		
		private String Director;
		
		@Column(name = "anio")
		private String Year;	
		
		private String Runtime;
		
		private String Poster;
		
		public Pelicula() {
			super();
		}

		public Pelicula(String titulo, String director, String year, String duracion, String idPeli, String poster) {
			super();
			this.Title = titulo;
			this.Director = director;
			this.Year = year;
			this.Runtime = duracion;
			this.imdbID = idPeli;
			this.Poster = poster;
		}
		
		public void copia(PeliculaComp p2) {
			this.Director=p2.getDirector();
			this.imdbID=p2.getIdPeli();
			this.Poster=p2.getPoster();
			this.Runtime=p2.getDuracion();
			this.Title=p2.getTitulo();
			this.Year=p2.getYear();
		}

		@Override
		public String toString() {
			return "Pelicula [idPeli=" + imdbID + ", titulo=" + Title + ", director=" + Director + ", year=" + Year
					+ ", duracion=" + Runtime + ", poster=" + Poster + "]";
		}

		public String getIdPeli() {
			return imdbID;
		}

		public void setIdPeli(String idPeli) {
			this.imdbID = idPeli;
		}

		public String getTitulo() {
			return Title;
		}

		public void setTitulo(String titulo) {
			this.Title = titulo;
		}

		public String getDirector() {
			return Director;
		}

		public void setDirector(String director) {
			this.Director = director;
		}

		public String getYear() {
			return Year;
		}

		public void setYear(String year) {
			this.Year = year;
		}

		public String getDuracion() {
			return Runtime;
		}

		public void setDuracion(String duracion) {
			this.Runtime = duracion;
		}

		public String getPoster() {
			return Poster;
		}

		public void setPoster(String poster) {
			this.Poster = poster;
		}

		

		
		
		
	  


}
