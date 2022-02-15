package com.bolsaideas.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

/**
 * Le damos un nombre al servicio para diferenciar entre las diferentes
 * implementaciones de la interfaz IServicio
 * 
 * @author Adrián
 *
 */
@Service("miServicioSimple")
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante...";
	}
}
