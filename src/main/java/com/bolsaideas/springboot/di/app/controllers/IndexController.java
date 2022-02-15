package com.bolsaideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsaideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {

	/**
	 * Con autowired spring maneja las inyecciones de dependencias automáticamente
	 * Con el qualifier indicamos que componente de los que implementan la interfaz
	 * queremos implementar Comentadas diferentes formas de inyectar
	 */
//	@Autowired
//	@Qualifier(value = "miServicioSimple")
//	private IServicio servicio;
	private IServicio servicio;

	/**
	 * Cuándo inyectamos por constructor podemos hasta quitar el autowired
	 * 
	 * @param servicio
	 */
	@Autowired
	public IndexController(IServicio servicio) {
		this.servicio = servicio;
	}

	@GetMapping({ "/index", "/", "home" })
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

//	@Autowired
//	public void setServicio(IServicio servicio) {
//		this.servicio = servicio;
//	}

}
