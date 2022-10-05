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

import com.idat.pe.model.Universidad;
import com.idat.pe.service.UniversidadService;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadController {

	@Autowired
	private UniversidadService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Universidad>> listar(){
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
		
	}
	@RequestMapping(path= "/guardar", method = RequestMethod.POST )
	public ResponseEntity<Void> guardar(@RequestBody Universidad u){
		service.guardar(u);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path= "/actualizar", method = RequestMethod.PUT )
	public ResponseEntity<Void> actualizar(@RequestBody Universidad u){
		Universidad universidad= service.obtener(u.getIduniversidad());
		if(universidad !=null) {
			service.actualizar(u);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Universidad universidad = service.obtener(id);
		if(universidad !=null) {
			service.eliminar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}

	@RequestMapping(path="/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<Universidad> obtener(@PathVariable Integer id){
		Universidad universidad = service.obtener(id);
		if(universidad !=null) {
			return new ResponseEntity<>(universidad, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}

}
