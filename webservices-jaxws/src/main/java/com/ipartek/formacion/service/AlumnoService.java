package com.ipartek.formacion.service;

import java.util.Map;

import com.ipartek.formacion.pojo.Alumno;

public interface AlumnoService {

	public Map<Integer, Alumno> getAll();
	public Alumno getById(int codigo);
}
