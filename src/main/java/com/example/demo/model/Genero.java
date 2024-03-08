package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_genero")
public class Genero {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long id_genero;
	
	@Column(name = "genero", nullable = false)
	private String genero;
	
	public Genero() {
		
	}

	public Long getId_genero() {
		return id_genero;
	}

	public void setId_genero(Long id_genero) {
		this.id_genero = id_genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
}
