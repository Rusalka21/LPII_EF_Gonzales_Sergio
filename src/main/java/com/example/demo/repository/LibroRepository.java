package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	
	List<Libro> findByFechaRegistroGreaterThanEqual(Date fechaRegistro);

}
