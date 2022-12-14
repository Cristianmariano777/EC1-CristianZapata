package com.idat.pe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="universidad")
public class Universidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iduniversidad;
	private String universidad;
	
	@OneToOne
	private MallaCurricular mallacurricular;
	
	public Integer getIduniversidad() {
		return iduniversidad;
	}
	public void setIduniversidad(Integer iduniversidad) {
		this.iduniversidad = iduniversidad;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	

}
