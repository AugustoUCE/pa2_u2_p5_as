package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Orden;

public interface IClienteServ {

	public void guardar(Cliente cliente);

	public void actualizar(Cliente cliente);

	// NativeQuery
	public Cliente buscarPorCedula(String cedula);

	public Cliente buscarPorNombre(String nombre);

	public List<Cliente> buscarPorFechaDeNacimiento(LocalDateTime fechaDeNacimiento);

	public List<Cliente> buscarPorSexo(String sexo);

	public List<Orden> buscarPorTotal(BigDecimal total);

	// typedQuery
	public List<Orden> buscarPorDescripcion(String descripcion);

	public List<Orden> buscarPorFecha(LocalDateTime fecha);
	
	public List<Orden> buscarPorMetodoDePago(String methPago);
	public List<Orden> buscarPorId(Integer id);
	
	public Cliente buscarPorIdCliente(Integer id);
}
