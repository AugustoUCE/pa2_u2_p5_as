package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

		//Criteria API Query 
	
		Ciudadano ciu=this.ciudadanoService.buscarPorApellido("salazar");
		System.out.println(ciu);
		
		Ciudadano ciu1=this.ciudadanoService.buscarPorCriteria("augusto", "salazar", "1752083905");
				System.out.println(ciu1);
				
		Ciudadano ciu2=this.ciudadanoService.buscarPorCriteria("augusto", "salazar", "0552083905");
		System.out.println(ciu2);	
		
		//Ciudadano ciu3=this.ciudadanoService.buscarPorCriteria("augusto", "salazar", "0652083905");
		//System.out.println(ciu3);
		
		System.out.println("\nCriteria API Query AND OR ");
		Ciudadano ciu4=this.ciudadanoService.buscarPorCriteriaAndOr("augusto", "salazar", "1752083905");
		System.out.println(ciu4);
		
		Ciudadano ciu5=this.ciudadanoService.buscarPorCriteriaAndOr("augusto", "salazar", "0552083905");
		System.out.println(ciu5);
		
		
		
		
	}
	

}
