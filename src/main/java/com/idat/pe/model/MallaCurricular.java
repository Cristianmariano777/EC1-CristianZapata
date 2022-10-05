package com.idat.pe.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="malla")
public class MallaCurricular {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmalla;
	private String anio;
	
	@OneToOne
	private Universidad universidad;
	
	@OneToMany(mappedBy = "mallascursos")
	private List<Curso> cursos;
	
	
	public Integer getIdmalla() {
		return idmalla;
	}
	public void setIdmalla(Integer idmalla) {
		this.idmalla = idmalla;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	

}
