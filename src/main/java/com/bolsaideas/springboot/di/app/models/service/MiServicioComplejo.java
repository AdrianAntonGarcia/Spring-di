package com.bolsaideas.springboot.di.app.models.service;

/**
 * Le damos un nombre al servicio para diferenciar entre las diferentes
 * implementaciones de la interfaz IServicio Tenemos que tener siempre un
 * constructor sin parámetros (BEAN) Con el primary decimos que está es la clase
 * de las que implementan IServicio que sea la principal que se inyecte si no se
 * dice lo contrario
 * 
 * @author Adrián
 *
 */
//@Service("miServicioComplejo")
//@Primary
public class MiServicioComplejo implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante complicado...";
	}
}
