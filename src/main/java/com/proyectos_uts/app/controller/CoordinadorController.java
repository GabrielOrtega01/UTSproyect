package com.proyectos_uts.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectos_uts.app.entity.CoordinadorEntity;
import com.proyectos_uts.app.repository.CoordinadorRepository;



@Controller
public class CoordinadorController {

	@Autowired
	private CoordinadorRepository coordinadorRepository;

	@GetMapping("/listar-ccor")
	public String listar(Model model) {
		List<CoordinadorEntity> listar = coordinadorRepository.findAll();

		model.addAttribute("listarCoordinador", listar);

		return "listarCoor";
	}

	@GetMapping("/crearCoor")
	public String crear(Model model) {
		model.addAttribute("coor", new CoordinadorEntity());

		return "formCoor";
	}

	@PostMapping("/guardarCoor")
	public String guardar(CoordinadorEntity coor) {
		coordinadorRepository.save(coor);

		return "redirect:/listar-ccor";
	}

	@GetMapping("/editarCoor/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("coor", coordinadorRepository.findById(id).get());

		return "formCoor";
	}

	@GetMapping("/eliminarCoor/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		coordinadorRepository.deleteById(id);

		return "redirect:/listar-ccor";
	}

	//INDEX
	@GetMapping("/home-coor/{id}")
	public String home(@PathVariable Long id, Model model) {
		model.addAttribute("coor", coordinadorRepository.findById(id).get());

		return "homeCoor";
	}
}
