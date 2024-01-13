package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void actulizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro l = this.seleccionar(id);
		this.entityManager.remove(l);
	}

//Query
	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		// SELECT * FROM libro WHERE l.libro_titulo= ?
		// SELECT l FROM libro l WHERE l.titulo =: variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo =: variable");
		myQuery.setParameter("variable", nombre);
		return (Libro) myQuery.getSingleResult();
	}

	// cuando quiero que sea mayor
	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		String jpql = "SELECT l FROM  Libro l WHERE l.fechaPublicacion >= : fecha";
		Query myQuery = this.entityManager.createQuery(jpql);
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		String jpql = "SELECT l FROM Libro l WHERE l.titulo =: var";
		TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery(jpql, Libro.class);
		myTypedQuery.setParameter("var", titulo);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		String jpql = "SELECT l FROM Libro l WHERE l.fechaPublicacion >=: var";
		TypedQuery<Libro> mytyped = this.entityManager.createQuery(jpql, Libro.class);
		mytyped.setParameter("var", fecha);
		return mytyped.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		String nombreDelNamedQuery="Libro.queryBuscarPorTitulo";
		TypedQuery<Libro> myQuery=this.entityManager.createNamedQuery(nombreDelNamedQuery,Libro.class);
		myQuery.setParameter("var", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		String nombreDelNamedQuery="Libro.queryBuscarPorFecha";
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery(nombreDelNamedQuery, Libro.class);
		myQuery.setParameter("var", fecha);
	
		return myQuery.getResultList();
	}

}
