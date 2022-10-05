package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.Curso;

public interface CursoService {
	
	List<Curso> listar();
	Curso obtener (Integer id);
	void guardar (Curso curso);
	void eliminar (Integer id);
	void actualizar (Curso curso);

}
