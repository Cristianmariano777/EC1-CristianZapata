package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Profesor;

public interface ProfesorService {
	
	List<Profesor> listar();
	Profesor obtener(Integer id);
	void guardar (Profesor profesor);
	void eliminar (Integer id);
	void actualizar (Profesor profesor);
	

}
