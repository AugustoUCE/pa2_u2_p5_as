package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5AsApplication implements CommandLineRunner {

	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	
	
		
	
		
		
		Empleado e = new Empleado();
	
		e.setFechaIngreso(LocalDateTime.now());
		e.setSalario(new BigDecimal(5100));
		
		
		
	
		
		Ciudadano c1 = new Ciudadano();
		c1.setNombre("Jairo");
		c1.setApellido("Salazar");
			
		e.setCiudadano(c1);
		c1.setEmpleado(e);
		
		this.ciudadanoService.guardar(c1);
	}

}
