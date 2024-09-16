package com.proyectos_uts.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectos_uts.app.entity.EstudianteEntity;
import com.proyectos_uts.app.repository.EstudianteRepository;



@Controller
public class EstudianteController {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@GetMapping("/listar-est")
	public String listar(Model model) {
		List<EstudianteEntity> listar = estudianteRepository.findAll();

		model.addAttribute("listarEst", listar);

		return "listarEst";
	}

	@GetMapping("/crearEst")
	public String crear(Model model) {
		model.addAttribute("est", new EstudianteEntity());

		return "formEst";
	}

	@PostMapping("/guardarEst")
	public String guardar(EstudianteEntity est) {
		estudianteRepository.save(est);

		return "redirect:/listar-est";
	}

	@GetMapping("/editarEst/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("est", estudianteRepository.findById(id).get());

		return "formEst";
	}

	@GetMapping("/eliminarEst/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		estudianteRepository.deleteById(id);

		return "redirect:/listar-est";
	}

	//INDEX
	@GetMapping("/home-est/{id}")
	public String home(@PathVariable Long id, Model model) {
		model.addAttribute("eva", estudianteRepository.findById(id).get());
		model.addAttribute("id", id);

		return "homeEst";
	}
}
