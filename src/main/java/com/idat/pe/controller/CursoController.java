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

import com.idat.pe.model.Curso;
import com.idat.pe.service.CursoService;

@RestController
@RequestMapping("/curso/v1")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Curso>> listar(){
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
		
	}
	@RequestMapping(path= "/guardar", method = RequestMethod.POST )
	public ResponseEntity<Void> guardar(@RequestBody Curso c){
		service.guardar(c);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path= "/actualizar", method = RequestMethod.PUT )
	public ResponseEntity<Void> actualizar(@RequestBody Curso c){
		Curso curso = service.obtener(c.getIdcurso());
		if(curso !=null) {
			service.actualizar(c);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Curso curso = service.obtener(id);
		if(curso !=null) {
			service.eliminar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}

	@RequestMapping(path="/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> obtener(@PathVariable Integer id){
		Curso curso = service.obtener(id);
		if(curso !=null) {
			return new ResponseEntity<>(curso, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}

}
