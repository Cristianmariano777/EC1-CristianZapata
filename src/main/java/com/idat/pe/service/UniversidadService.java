package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Universidad;

public interface UniversidadService {
	
	List<Universidad> listar();
	Universidad obtener (Integer id);
	void guardar (Universidad universidad);
	void eliminar (Integer id);
	void actualizar (Universidad universidad);


}
