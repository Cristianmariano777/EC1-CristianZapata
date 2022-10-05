package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Universidad;
import com.idat.pe.repository.UniversidadRepository;

@Service
public class UniversidadServiceImp implements UniversidadService {
	
	@Autowired
	private UniversidadRepository repository;

	@Override
	public List<Universidad> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Universidad obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Universidad universidad) {
		// TODO Auto-generated method stub
		repository.save(universidad);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(Universidad universidad) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(universidad);

	}

}
