package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5AsApplication implements CommandLineRunner {
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante estu = new Estudiante();
		estu.setNombre("Augusto");
		estu.setApellido("Salazar");
		estu.setCedula("1752083905");
		estu.setFechaNacimiento(LocalDateTime.of(1999, 07, 07, 07, 07));

		// this.estudianteService.guardar(estu);

		// System.out.println(this.estudianteService.buscar(16));

		Alumno alu = new Alumno();
		alu.setNombre("Augusto");
		//this.alumnoService.guardar(alu);
		//System.out.println(this.alumnoService.buscar(4));
		this.alumnoService.eliminar(4);
	/*	Alumno alu1 =this.alumnoService.buscar(1);
		alu1.setNombre("Jazmin");
		this.alumnoService.actualizar(alu1);
*/
	}

}
