package com.example.demo.model;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_libro")
public class Libro {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_libro")
	    private Long id_libro;

	    @Column(name = "nombre", nullable = false, length = 60)
	    private String nombre;

	    @Column(name = "autor", nullable = false, length = 60)
	    private String autor;

	    @Column(name = "fecha_publicacion", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date fecha_publicacion;

	    @ManyToOne
		@JoinColumn(name = "id_genero", nullable = false)
	    private Genero genero;    
	    
	    @Column(name = "fecha_registro", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date fechaRegistro;
	    
	    
	    public Libro() {
	    		    	
	    }


		public Long getId_libro() {
			return id_libro;
		}


		public void setId_libro(Long id_libro) {
			this.id_libro = id_libro;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getAutor() {
			return autor;
		}


		public void setAutor(String autor) {
			this.autor = autor;
		}


		public Date getFecha_publicacion() {
			return fecha_publicacion;
		}


		public void setFecha_publicacion(Date fecha_publicacion) {
			this.fecha_publicacion = fecha_publicacion;
		}


		public Genero getGenero() {
			return genero;
		}


		public void setGenero(Genero genero) {
			this.genero = genero;
		}


		public Date getFechaRegistro() {
			return fechaRegistro;
		}


		public void setFechaRegistro(Date fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}
		
		
}
