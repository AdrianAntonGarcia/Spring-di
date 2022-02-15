package com.bolsaideas.springboot.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.di.models.service.MiServicio;

@Controller
public class IndexController {
	private MiServicio servicio = new MiServicio();

	@GetMapping({ "/index", "/", "home" })
	public String index(Model model) {
		model.addAttribute("prueba", servicio.operacion());
		model.addAttribute("dato", "dato");
		return "index";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

//		usuarios.add(new Usuario("Andres", "Guzmán", "andres@correo.com"));
//		usuarios.add(new Usuario("Adrián", "Antón", "adrian@correo.com"));
//		usuarios.add(new Usuario("Ana", "Romeu", "ana@correo.com"));
		model.addAttribute("titulo", "texto");
//		model.addAttribute("usuarios", usuarios);
		return "listar";
	}

}
