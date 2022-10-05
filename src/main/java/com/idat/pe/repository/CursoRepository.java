package com.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
