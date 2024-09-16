package com.proyectos_uts.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectos_uts.app.entity.EvaluadorEntity;
import com.proyectos_uts.app.repository.EvaluadorRepository;



@Controller
public class EvaluadorController {

	@Autowired
	private EvaluadorRepository evaluadorRepository;

	@GetMapping("/listar-eva")
	public String listar(Model model) {
		List<EvaluadorEntity> listar = evaluadorRepository.findAll();

		model.addAttribute("listarEva", listar);

		return "listarEva";
	}

	@GetMapping("/crearEva")
	public String crear(Model model) {
		model.addAttribute("eva", new EvaluadorEntity());

		return "formEva";
	}

	@PostMapping("/guardarEva")
	public String guardar(EvaluadorEntity eva) {
		evaluadorRepository.save(eva);

		return "redirect:/listar-eva";
	}

	@GetMapping("/editarEva/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("eva", evaluadorRepository.findById(id).get());

		return "formEva";
	}

	@GetMapping("/eliminarEva/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		evaluadorRepository.deleteById(id);

		return "redirect:/listar-eva";
	}

	//INDEX
	@GetMapping("/home-eva/{id}")
	public String home(@PathVariable Long id, Model model) {
		model.addAttribute("eva", evaluadorRepository.findById(id).get());
		model.addAttribute("id", id);

		return "homeEva";
	}
}
