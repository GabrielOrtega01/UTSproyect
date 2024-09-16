package com.proyectos_uts.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyectos_uts.app.repository.AdministradorRepository;



@Controller
public class AdminController {

	@Autowired
	private AdministradorRepository administradorRepository;

	@GetMapping("/home-admin/{id}")
	public String home(@PathVariable Long id, Model model) {
		model.addAttribute(administradorRepository.findById(id).get());
		model.addAttribute("idAdmin", id);

		return "homeAdmin";
	}
}
