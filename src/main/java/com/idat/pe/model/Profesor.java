package com.idat.pe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idprofesor;
	private String profesor;
	
	@ManyToMany
	@JoinTable(name="curso_profesor", 
			joinColumns=@JoinColumn(name="idprofesor",nullable=false, unique= true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idprofesor) references profesor (idprofesor)")),
			inverseJoinColumns = @JoinColumn(name="idcurso",nullable=false, unique= true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idcurso) references curso (idcurso)"))
				)
	
	private List<Curso> curso = new ArrayList<>();
	
	
	public Integer getIdprofesor() {
		return idprofesor;
	}
	public void setIdprofesor(Integer idprofesor) {
		this.idprofesor = idprofesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	
}
