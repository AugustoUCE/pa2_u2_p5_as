package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	
	public void insertar(Ciudadano ciudadano);
	public Ciudadano seleccionar(Integer id);
	
	public Empleado seleccionarPorCedula(String cedula);
	
	public Ciudadano seleccionarPorCedulaCiu(String cedula);
	
	public Ciudadano seleccionarPorApellido(String apellido);
	
	//funcionalidad que cuando sea el ciudadano de pichincha lo busque por nombre
	//cuando sea de cotopaxi lo budque por apellido
	//cuando no sea ninguna ni de cotopaxi ni pichincha lo busque por cedula
	public Ciudadano seleccionarPorCriteria(String nombre,String apellido,String cedula);
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre,String apellido,String cedula);
	
}
