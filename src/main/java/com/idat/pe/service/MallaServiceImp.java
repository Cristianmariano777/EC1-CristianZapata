package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.MallaCurricular;
import com.idat.pe.repository.MallaRepository;

@Service
public class MallaServiceImp implements MallaService {
	
	@Autowired
	private MallaRepository repository;

	@Override
	public List<MallaCurricular> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public MallaCurricular obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(MallaCurricular mallaCurricular) {
		// TODO Auto-generated method stub
		repository.save(mallaCurricular);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(MallaCurricular mallaCurricular) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(mallaCurricular);

	}

}
