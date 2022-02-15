package com.bolsaideas.springboot.di.app.models.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * El scope por defecto es singleton que sea crea cuándo se ejecuta la app y se
 * destruye al terminar. (Siempre la misma instancia)
 * 
 * Con el escope @RequestScope, el componente se construye y destruye al
 * realizar la petición http. http://localhost:8080/factura/ver
 * 
 * Con el escope @SessionScope, el componente se construye con la sesión del
 * usuario y se destruye cuándo se cierra el navegador o un timeout. Debe
 * implementar serializable
 * 
 * Con el escope @ApplicationScope, muy similar al singleton, pero se guarda en
 * el servlet context y no en el context de spring. Podemos tener varios
 * contextos. Por defecto se suele usar solo un contexto
 * 
 * Ej error: Cannot deserialize session attribute
 * [org.springframework.web.context.request.ServletRequestAttributes.DESTRUCTION_CALLBACK.scopedTarget.factura]
 * for session [4626B2D36D68841D63582CC684F02644]
 * 
 * @author Adrián
 *
 */
@Component
@RequestScope
public class Cliente implements Serializable {

	private static final long serialVersionUID = -7070002316048246050L;

	@Value("${cliente.nombre}")
	private String nombre;

	@Value("${cliente.apellido}")
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
