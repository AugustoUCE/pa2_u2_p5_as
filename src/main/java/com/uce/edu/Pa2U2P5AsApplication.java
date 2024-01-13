package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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

		// Query
		System.out.println("Query");
		Libro l1 = this.libroService.buscarPorNombre("JAVA");
		System.out.println(l1);
		List<Libro> listPorFecha = this.libroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));

		for (Libro libro : listPorFecha) {
			System.out.println(libro);
		}

		// TypedQuery
		System.out.println("TypedQuery");
		Libro l = this.libroService.buscarPorTitulo("JAVA");
		System.out.println(l);

		List<Libro> list = this.libroService.buscarPorFechaPublicacion(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : list) {
			System.out.println(libro);
		}

		// NamedQuery
		System.out.println("NamedQuery");
		Libro l2 = this.libroService.buscarPorTitulo("PYTHON");
		System.out.println(l2);

		List<Libro> listNamed = this.libroService.buscarPorFechaNamed(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : listNamed) {
			System.out.println(libro);
		}

	}

}
