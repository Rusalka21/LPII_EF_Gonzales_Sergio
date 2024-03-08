package com.example.demo.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Genero;
import com.example.demo.model.Libro;
import com.example.demo.service.GeneroService;
import com.example.demo.service.LibroService;



@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping ("/list")
	public String listaLibros(Model model) {
		
		List<Libro> listLibro = libroService.getAllLibro();
		
		model.addAttribute("libros", listLibro);
		
		return "listLibro";
		
	}
	
	@GetMapping ("/register")
	public String registerForm(Model model) {
		
		List<Genero> listGenero = generoService.getAllGenero();
		
		model.addAttribute("generos", listGenero);
		
		return "libroRegister";
	}
	
	@PostMapping ("/register")
	public String registerLibro(@RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "autor") String autor,
			@RequestParam(name = "fecha_publicacion") Date fecha_publicacion,
			@RequestParam(name = "id_genero") Long id_genero,
			@RequestParam(name = "fecha_registro") Date fecha_registro,
			Model model) {
		
		Libro libro = new Libro();
		
		libro.setNombre(nombre);
		libro.setAutor(autor);
		libro.setFecha_publicacion(fecha_publicacion);
		
		Genero genero = generoService.getGeneroById(id_genero);
		libro.setGenero(genero);	
		libro.setFechaRegistro(fecha_registro);
		
		
		libroService.createLibro(libro);
		
		List<Libro> listLibro = libroService.getAllLibro();
		List<Genero> listGenero = generoService.getAllGenero();
		
		model.addAttribute("libros", listLibro);
		model.addAttribute("generos", listGenero);
		
		return "listLibro";
	}
	
	@GetMapping ("/edit/{id_libro}")
	public String editForm(@PathVariable Long id_libro,
			Model model) {
		
		Libro libro = libroService.getLibroByID(id_libro);		
		
		model.addAttribute("libro", libro);
		model.addAttribute("generos", generoService.getAllGenero());
		
		
		return "libroEdit";
	}
	
	@PostMapping("/edit")
	public String editLibro(@RequestParam(name = "id_libro") Long id_libro,
			@RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "autor") String autor,
			@RequestParam(name = "fecha_publicacion") Date fecha_publicacion,
			@RequestParam(name = "id_genero") Long id_genero,
			@RequestParam(name = "fecha_registro") Date fecha_registro,
			Model model) {
		
		Libro libro = libroService.getLibroByID(id_libro);
		
		libro.setNombre(nombre);
		libro.setAutor(autor);
		libro.setFecha_publicacion(fecha_publicacion);
		
		Genero genero = generoService.getGeneroById(id_genero);
		libro.setGenero(genero);
		libro.setFechaRegistro(fecha_registro);
		
		libroService.createLibro(libro);
		
		List<Libro> listLibro = libroService.getAllLibro();
		
		model.addAttribute("libros", listLibro);
		
		return "listLibro";
	}
	
	@GetMapping("/delete/{id_libro}")
	public String deleteLibro(@PathVariable Long id_libro, Model model) {
		
		libroService.deleteLibro(id_libro);
		
		List<Libro> listLibro = libroService.getAllLibro();
		
		model.addAttribute("libros", listLibro);
		
		return "listLibro";
	}
	
}	


