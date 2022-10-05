package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Curso;
import com.idat.pe.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService {

	@Autowired
	private CursoRepository repository;
	
	@Override
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Curso obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Curso curso) {
		// TODO Auto-generated method stub
		repository.save(curso);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(curso);
	}

}
