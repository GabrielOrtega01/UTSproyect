package com.proyectos_uts.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectos_uts.app.entity.DirectorEntity;
import com.proyectos_uts.app.repository.DirectorRepository;



@Controller
public class DirectorController {

	@Autowired
	private DirectorRepository directorRepository;

	@GetMapping("/listar-dir")
	public String listar(Model model) {
		List<DirectorEntity> listar = directorRepository.findAll();

		model.addAttribute("listarDir", listar);

		return "listarDir";
	}

	@GetMapping("/crearDir")
	public String crear(Model model) {
		model.addAttribute("dir", new DirectorEntity());

		return "formDir";
	}

	@PostMapping("/guardarDir")
	public String guardar(DirectorEntity dir) {
		directorRepository.save(dir);

		return "redirect:/listar-dir";
	}

	@GetMapping("/editarDir/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("dir", directorRepository.findById(id).get());

		return "formDir";
	}

	@GetMapping("/eliminarDir/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		directorRepository.deleteById(id);

		return "redirect:/listar-dir";
	}

	//INDEX
	@GetMapping("/home-dir/{id}")
	public String home(@PathVariable Long id, Model model) {
		model.addAttribute("dir", directorRepository.findById(id).get());
		model.addAttribute("id", id);

		return "homeDir";
	}
}
