package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AsApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;

	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Libro l = new Libro();
		l.setFechaPublicacion(LocalDateTime.now());
		l.setTitulo("JAVA");
		
		
		Autor a=new Autor();
		a.setNacional("Ecuatoriano");
		a.setNombre("Nacho");
		
		Autor a1=new Autor();
		a1.setNacional("Mexicano");
		a1.setNombre("Pepito");
		
		Set<Autor> autores = new HashSet<>();
		autores.add(a);
		autores.add(a1);
		
		l.setAutores(autores);
		
		Set<Libro> libros = new HashSet<>();
		libros.add(l);
		
		a.setLibros(libros);
		a1.setLibros(libros);
		
		this.libroService.guardar(l);

	}

}
