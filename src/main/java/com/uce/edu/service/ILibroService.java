package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {

	public Libro buscar(Integer id);

	public void guardar(Libro libro);

	public void guardar(Libro2 libro2);

	public void actulizar(Libro libro);

	public void eliminar(Integer id);

	//Query
	public Libro buscarPorNombre(String nombre);
	public List<Libro> buscarPorFechaPublicacion(LocalDateTime fecha);
	//Typed
	public Libro buscarPorTitulo(String titulo);
	public List<Libro> buscarPorFechaTyped(LocalDateTime fecha);	
	//NamedQuery
	public Libro buscarPorTituloNamed(String titulo);
	public List<Libro> buscarPorFechaNamed(LocalDateTime fecha);
	
}
