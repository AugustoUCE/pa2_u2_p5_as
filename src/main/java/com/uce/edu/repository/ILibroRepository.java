package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {

	public Libro seleccionar(Integer id);

	public void insertar(Libro libro);

	public void insertar(Libro2 libro2);

	public void actulizar(Libro libro);

	public void eliminar(Integer id);

	//Query
	public Libro seleccionarPorNombre(String nombre);
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fecha);
	
	//Typed
	public Libro seleccionarPorTitulo(String titulo);
	public List<Libro> seleccionarPorFechaTyped(LocalDateTime fecha);
	
	//NamedQuery
	public Libro seleccionarPorTituloNamed(String titulo);
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fecha);
	

}
