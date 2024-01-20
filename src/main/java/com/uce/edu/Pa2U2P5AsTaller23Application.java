package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Orden;
import com.uce.edu.service.IClienteServ;

@SpringBootApplication
public class Pa2U2P5AsTaller23Application implements CommandLineRunner {

	@Autowired
	private IClienteServ clienteServ;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AsTaller23Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// NativeQuery
		System.out.println("\ttNativeQuery");
		System.out.println("\tEjemplo 1 NativeQuery:");
		Cliente c2 = this.clienteServ.buscarPorCedula("1752083905");
		System.out.println(c2);

		System.out.println("\tEjemplo 2 NativeQuery:");
		Cliente c3 = this.clienteServ.buscarPorNombre("augusto");
		System.out.println(c3);
		

		System.out.println("\tEjemplo 3 NativeQuery:");
		List<Cliente> c = this.clienteServ.buscarPorFechaDeNacimiento(LocalDateTime.of(2024, 1, 20, 1, 1));
		for (Cliente cliente : c) {
			System.out.println(cliente);
		}
		System.out.println("\tEjemplo 4 NativeQuery:");
		List<Cliente> c4 = this.clienteServ.buscarPorSexo("mujer");
		for (Cliente cliente4 : c4) {
			System.out.println(cliente4);
		}

		System.out.println("\tEjemplo 5 NativeQuery:");
		List<Orden> listaOrdenNative = this.clienteServ.buscarPorTotal(new BigDecimal(100));
		for (Orden orden5 : listaOrdenNative) {
			System.out.println(orden5);
		}

		
		
		// typedQuery
		System.out.println("\t \n TypedQuery");
		System.out.println("\tEjemplo 1 TypedQuery:");
		List<Orden> listaO1 = this.clienteServ.buscarPorDescripcion("espera");
		for (Orden orden1 : listaO1) {
			System.out.println(orden1);
		}
		System.out.println("\tEjemplo 2 TypedQuery:");
		List<Orden> listaO2 = this.clienteServ.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 1, 1));
		for (Orden orden2 : listaO2) {
			System.out.println(orden2);
		}
	
	
		System.out.println("\tEjemplo 3 TypedQuery:");
		List<Orden> listaO4 = this.clienteServ.buscarPorMetodoDePago("tarjeta");
		for (Orden orden4 : listaO4) {
			System.out.println(orden4);
		}
		System.out.println("\tEjemplo 4 TypedQuery:");
		List<Orden> listaO3 = this.clienteServ.buscarPorId(1);
		for (Orden orden3 : listaO3) {
			System.out.println(orden3);
		}
		
		System.out.println("\tEjemplo 5 TypedQuery:");
		Cliente cliTyped=this.clienteServ.buscarPorIdCliente(1);
		System.out.println(cliTyped);
		
	}
}
