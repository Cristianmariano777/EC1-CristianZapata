package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.Profesor;
import com.idat.pe.service.ProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Profesor>> listar(){
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
		
	}
	@RequestMapping(path= "/guardar", method = RequestMethod.POST )
	public ResponseEntity<Void> guardar(@RequestBody Profesor p){
		service.guardar(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path= "/actualizar", method = RequestMethod.PUT )
	public ResponseEntity<Void> actualizar(@RequestBody Profesor p){
		Profesor profesor = service.obtener(p.getIdprofesor());
		if(profesor !=null) {
			service.actualizar(p);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor profesor = service.obtener(id);
		if(profesor !=null) {
			service.eliminar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}

	@RequestMapping(path="/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtener(@PathVariable Integer id){
		Profesor profesor = service.obtener(id);
		if(profesor !=null) {
			return new ResponseEntity<>(profesor, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}

}
