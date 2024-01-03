package com.uce.edu.service;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionesService {

	public Habitacion buscar(Integer id);

	public void guardar(Habitacion habitacion);

	public void actulizar(Habitacion habitacion);

	public void eliminar(Integer id);

}
