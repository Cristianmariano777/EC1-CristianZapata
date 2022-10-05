package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Profesor;
import com.idat.pe.repository.ProfesorRepository;

@Service
public class ProfesorServiceImp implements ProfesorService {
	
	@Autowired
	private ProfesorRepository repository;

	@Override
	public List<Profesor> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Profesor obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
		repository.save(profesor);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(profesor);

	}

}
