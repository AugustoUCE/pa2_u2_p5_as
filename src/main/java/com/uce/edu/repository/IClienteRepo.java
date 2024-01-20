package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Orden;

public interface IClienteRepo {

	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	// NativeQuery
	public Cliente seleccionarPorCedula(String cedula);

	public Cliente seleccionarPorNombre(String nombre);

	public List<Cliente> seleccionarPorFechaDeNacimiento(LocalDateTime fechaDeNacimiento);

	public List<Cliente> seleccionarPorSexo(String sexo);

	public List<Orden> seleccionarPorTotal(BigDecimal total);

	// typedQuery
	public List<Orden> seleccionarPorDescripcion(String descripcion);

	public List<Orden> seleccionarPorFecha(LocalDateTime fecha);

	public List<Orden> seleccionarPorMetodoDePago(String methPago);
	
	public List<Orden> seleccionarPorId(Integer id);
	
	public Cliente seleccionarPorIdCliente(Integer id);

}
