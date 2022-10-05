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

import com.idat.pe.model.MallaCurricular;
import com.idat.pe.service.MallaService;

@RestController
@RequestMapping("/universidad/v1")
public class MallaController {

	@Autowired
	private MallaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<MallaCurricular>> listar(){
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
		
	}
	@RequestMapping(path= "/guardar", method = RequestMethod.POST )
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricular m){
		service.guardar(m);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path= "/actualizar", method = RequestMethod.PUT )
	public ResponseEntity<Void> actualizar(@RequestBody MallaCurricular m){
		MallaCurricular mallaCurricular= service.obtener(m.getIdmalla());
		if(mallaCurricular !=null) {
			service.actualizar(m);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		MallaCurricular mallaCurricular = service.obtener(id);
		if(mallaCurricular !=null) {
			service.eliminar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}

	@RequestMapping(path="/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaCurricular> obtener(@PathVariable Integer id){
		MallaCurricular mallaCurricular = service.obtener(id);
		if(mallaCurricular !=null) {
			return new ResponseEntity<>(mallaCurricular, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}


	
}
