package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Orden;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM cliente c WHERE c.cli_cedula=:var";
		Query myQuery= this.entityManager.createNativeQuery(sql, Cliente.class);
		myQuery.setParameter("var", cedula);
		return (Cliente) myQuery.getSingleResult();
	}

	@Override
	public Cliente seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM cliente c WHERE c.cli_nombre=:var";
		Query myQuery= this.entityManager.createNativeQuery(sql, Cliente.class);
		myQuery.setParameter("var", nombre);
		return (Cliente) myQuery.getSingleResult();
	}

	@Override
	public List<Cliente> seleccionarPorFechaDeNacimiento(LocalDateTime fechaDeNacimiento) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM cliente c WHERE c.cli_fecha_nacimiento>=:var";
		Query myQuery= this.entityManager.createNativeQuery(sql, Cliente.class);
		myQuery.setParameter("var", fechaDeNacimiento);
		return (List<Cliente>)myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarPorSexo(String sexo) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM cliente c WHERE c.cli_sexo=:var";
		Query myQuery= this.entityManager.createNativeQuery(sql, Cliente.class);
		myQuery.setParameter("var", sexo);
		return myQuery.getResultList();
	}

	@Override
	public List<Orden> seleccionarPorDescripcion(String descripcion) {
		String jpql="SELECT o FROM Orden o WHERE o.descripcion=:var";
		TypedQuery<Orden> myQuery= this.entityManager.createQuery(jpql, Orden.class);
		myQuery.setParameter("var", descripcion);
		return myQuery.getResultList();
	}


	@Override
	public List<Orden> seleccionarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		String jpql="SELECT o FROM Orden o WHERE o.fecha>=:var";
		TypedQuery<Orden> myQuery= this.entityManager.createQuery(jpql, Orden.class);
		myQuery.setParameter("var", fecha);
		return (List<Orden>) myQuery.getResultList();
	}

	@Override
	public List<Orden> seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		String jpql="SELECT o FROM Orden o WHERE o.id >=:var";
		TypedQuery<Orden> myQuery= this.entityManager.createQuery(jpql, Orden.class);
		myQuery.setParameter("var", id);
		return (List<Orden>) myQuery.getResultList();
	}

	@Override
	public Cliente seleccionarPorIdCliente(Integer id) {
		// TODO Auto-generated method stub
		String jpql="SELECT c FROM Cliente c WHERE c.id =:var";
		TypedQuery<Cliente> myQuery= this.entityManager.createQuery(jpql, Cliente.class);
		myQuery.setParameter("var", id);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Orden> seleccionarPorTotal(BigDecimal total) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM orden o WHERE o.orden_total <=:var";

		Query myQuery= this.entityManager.createNativeQuery(sql, Orden.class);
		myQuery.setParameter("var", total);
		
		return (List<Orden>) myQuery.getResultList();
	}

	@Override
	public List<Orden> seleccionarPorMetodoDePago(String methPago) {
		// TODO Auto-generated method stub
		String jpql="SELECT o FROM Orden o WHERE o.metodoPago=:var";
		TypedQuery<Orden> myQuery=this.entityManager.createQuery(jpql,Orden.class);
		myQuery.setParameter("var", methPago);
		return (List<Orden>) myQuery.getResultList();
	}



}
