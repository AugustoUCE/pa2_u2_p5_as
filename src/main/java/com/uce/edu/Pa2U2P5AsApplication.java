package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		/*
		Libro2 l = new Libro2();
		l.setFechaPublicacion(LocalDateTime.now());
		l.setTitulo("JAVA2");
		
		
		Autor2 a=new Autor2();
		a.setNacional("Ecuatoriano");
		a.setNombre("Nacho");
		
		Autor2 a1=new Autor2();
		a1.setNacional("Mexicano");
		a1.setNombre("Pepito");
		
		Set<Autor2> autores = new HashSet<>();
		autores.add(a);
		autores.add(a1);
	
		
		AutorLibro auli=new AutorLibro();
		auli.setAutor2(a);
		auli.setLibro2(l);
		auli.setFecha(LocalDateTime.now());
		
		AutorLibro auli2=new AutorLibro();
		auli2.setAutor2(a1);
		auli2.setLibro2(l);
		auli2.setFecha(LocalDateTime.now());
		
		List<AutorLibro> listaAutorLibro= new ArrayList<>();
		
		listaAutorLibro.add(auli);
		listaAutorLibro.add(auli2);
		
		l.setAutoresLibros(listaAutorLibro);
		*/
		//this.libroService.guardar(l);
		
		Libro libro =this.libroService.buscarPorNombre("JAVA");
		System.out.println(libro);
		

	}

}
