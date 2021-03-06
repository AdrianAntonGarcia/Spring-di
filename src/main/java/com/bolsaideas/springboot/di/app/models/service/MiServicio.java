package com.bolsaideas.springboot.di.app.models.service;

/**
 * Le damos un nombre al servicio para diferenciar entre las diferentes
 * implementaciones de la interfaz IServicio Tenemos que tener siempre un
 * constructor sin parámetros (BEAN)
 * 
 * @author Adrián
 *
 */
//@Service("miServicioSimple")
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante simple...";
	}
}
