package com.bolsaideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class Factura implements Serializable {

	private static final long serialVersionUID = -4052502873227166074L;

	@Value("${factura.descripcion}")
	private String descripcion;

	@Autowired
	private Cliente cliente;

	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;

	/**
	 * Se ejecuta después de que se haya construido el objeto y se hayan inyectado
	 * las dependencias
	 */
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Adri"));
		descripcion = descripcion.concat(" del cliente").concat(cliente.getNombre());
	}

	/**
	 * Se ejecuta cuándo se destruye el componente
	 */
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
}
