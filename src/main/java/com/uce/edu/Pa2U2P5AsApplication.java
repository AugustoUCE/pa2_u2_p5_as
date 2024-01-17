package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AsApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	/*	
	//Query
		Libro l = this.libroService.buscarPorNombre("JAVA");
		System.out.println(l);
	
		List<Libro> list1=this.libroService.buscarPorFechaPublicacion(LocalDateTime.of(2024, 01, 10, 18, 0));
		for (Libro libro : list1) {
			System.out.println(libro);
			}
			
	
	//TypedQuery
		System.out.println("TypedQuery");
		Libro l1=this.libroService.buscarPorTitulo("JAVA");
		System.out.println(l1);
		
		List<Libro> list2=this.libroService.buscarPorFechaTyped(LocalDateTime.of(2024, 01, 10, 18, 0));
		for (Libro libro1 : list2) {
			System.out.println(libro1);
		}
	//NamedQuery
		
	System.out.println("NamedQuery");
	
	Libro l2=this.libroService.buscarPorTituloNamed("PYTHON");
	System.out.println(l2);
	
	List<Libro> list3=this.libroService.buscarPorFechaNamed(LocalDateTime.of(2024, 01, 10, 18, 0));
	for (Libro libro : list3) {
		System.out.println(libro);
	}
	*/
	
		Empleado emp = this.ciudadanoService.buscarPorCedula("175208");
		System.out.println(emp);
		
		Ciudadano cui=this.ciudadanoService.buscarPorCedulaCiu("175208");
		System.out.println(cui);
		
		
	}
	

}
