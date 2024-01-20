package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IClienteRepo;
import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Orden;

@Service
public class ClienteServImpl implements IClienteServ {

	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizar(cliente);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorCedula(cedula);
	}

	@Override
	public Cliente buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorNombre(nombre);
	}

	@Override
	public List<Cliente>  buscarPorFechaDeNacimiento(LocalDateTime fechaDeNacimiento) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorFechaDeNacimiento(fechaDeNacimiento);
	}

	@Override
	public List<Cliente> buscarPorSexo(String sexo) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorSexo(sexo);
	}

	@Override
	public List<Orden> buscarPorDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorDescripcion(descripcion);
	}

	@Override
	public List<Orden> buscarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return  this.clienteRepo.seleccionarPorFecha(fecha);
	}

	

	@Override
	public List<Orden> buscarPorTotal(BigDecimal total) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorTotal(total);
	}

	@Override
	public List<Orden> buscarPorMetodoDePago(String methPago) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorMetodoDePago(methPago);
	}

	@Override
	public List<Orden> buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorId(id);
	}

	@Override
	public Cliente buscarPorIdCliente(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.seleccionarPorIdCliente(id);
	}





}
