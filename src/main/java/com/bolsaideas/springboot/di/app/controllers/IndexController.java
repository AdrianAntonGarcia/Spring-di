package com.bolsaideas.springboot.di.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
//	private MiServicio servicio = new MiServicio();

	@GetMapping({ "/index", "/", "home" })
	public String index(Model model) {
//		model.addAttribute("prueba", servicio.operacion());
		model.addAttribute("dato", "dato");
		return "index";
	}

}
