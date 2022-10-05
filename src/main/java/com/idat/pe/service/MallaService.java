package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.MallaCurricular;

public interface MallaService {
	
	List<MallaCurricular> listar();
	MallaCurricular obtener (Integer id);
	void guardar (MallaCurricular mallaCurricular);
	void eliminar (Integer id);
	void actualizar (MallaCurricular mallaCurricular);




}
