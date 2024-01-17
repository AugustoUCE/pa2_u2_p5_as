package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		String jpql="SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula";
		TypedQuery<Empleado> myQuery=this.entityManager.createQuery(jpql, Empleado.class);
		myQuery.setParameter("cedula", cedula);	
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM ciudadano c WHERE c.ciud_cedula=:var";
		Query myQuery =this.entityManager.createNativeQuery(sql,Ciudadano.class);
		myQuery.setParameter("var", cedula);
		
		return (Ciudadano) myQuery.getSingleResult();
	}
	
	

}
