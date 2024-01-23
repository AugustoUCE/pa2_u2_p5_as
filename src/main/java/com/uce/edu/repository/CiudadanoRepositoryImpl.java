package com.uce.edu.repository;

import java.awt.Robot;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		//usar la interfaz de interaccion con la base de datos

		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> myCriteriaQuery=myCriteria.createQuery(Ciudadano.class);
		
		Root<Ciudadano> myFrom=myCriteriaQuery.from(Ciudadano.class);//from ciudadano
		Predicate condicionApellido=myCriteria.equal(myFrom.get("apellido"), apellido); //condicion
		//construir el sql final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		//Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> myTypedQuery=this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder myCriteriaBuilder=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> myCriteriaQuery=myCriteriaBuilder.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom=myCriteriaQuery.from(Ciudadano.class);
		
		//String digitosProvincia=cedula.substring(0,2);
		//System.out.println();
		
		Predicate condicionGenerica=null;
		
		if (cedula.startsWith("17")) {
			condicionGenerica=myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
			
		} else if(cedula.startsWith("05")){
			condicionGenerica=myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		}else {
			condicionGenerica=myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
		}
		
		myCriteriaQuery.select(myFrom).where(condicionGenerica);
		
		TypedQuery<Ciudadano> myTypedQuery=this.entityManager.createQuery(myCriteriaQuery);
		
		
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteriaBuilder=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> myCriteriaQuery=myCriteriaBuilder.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom=myCriteriaQuery.from(Ciudadano.class);
		
		//String digitosProvincia=cedula.substring(0,2);
		//System.out.println();
		
		Predicate condicionTotal=null;
		Predicate condicionNombre =myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		Predicate condicionApellido=myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		
		if (cedula.startsWith("17")) {
			condicionTotal=myCriteriaBuilder.or(condicionNombre,condicionApellido);
			
		} else if(cedula.startsWith("05")){
			condicionTotal=myCriteriaBuilder.and(condicionNombre,condicionApellido);

		}
		
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		
		TypedQuery<Ciudadano> myTypedQuery=this.entityManager.createQuery(myCriteriaQuery);
		
		
		return myTypedQuery.getSingleResult();
	
	}
	
	

}
