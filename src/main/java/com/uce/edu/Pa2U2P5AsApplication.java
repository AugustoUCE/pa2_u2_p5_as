package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5AsApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Hotel h = new Hotel();

		h.setNombre("Hotel Colon");
		h.setDireccion("Avenida Patria");

		Habitacion hab = new Habitacion();
		hab.setClase("vip");
		hab.setNumero("A1");
		hab.setHotel(h);

		Habitacion hab1 = new Habitacion();
		hab1.setClase("economica");
		hab1.setNumero("A2");
		hab1.setHotel(h);

		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(hab);
		habitaciones.add(hab1);

		//relacion
		h.setHabitaciones(habitaciones);
		this.hotelService.guardar(h);

	}

}
