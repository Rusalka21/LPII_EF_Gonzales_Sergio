package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository libroRepository;
	
	public List<Libro> getAllLibro() {
		
		return libroRepository.findAll();
	}
	
	public Libro createLibro(Libro libro){
		
		return libroRepository.save(libro);
		
	}
	
	public Libro getLibroByID(Long id) {
		
		return libroRepository.findById(id).orElse(null);
	}
	
	public void deleteLibro(Long id) {
		
		libroRepository.deleteById(id);
	}		
	
	public List<Libro> getLibrosByFechaRegistroGreaterThanEqual(Date fechaRegistro) {
        return libroRepository.findByFechaRegistroGreaterThanEqual(fechaRegistro);
    }
	
}
