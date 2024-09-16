package com.proyectos_uts.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectos_uts.app.entity.DirectorEntity;
import com.proyectos_uts.app.entity.EstudianteEntity;
import com.proyectos_uts.app.entity.EvaluadorEntity;
import com.proyectos_uts.app.entity.ProyectoEntity;
import com.proyectos_uts.app.repository.DirectorRepository;
import com.proyectos_uts.app.repository.EstudianteRepository;
import com.proyectos_uts.app.repository.EvaluadorRepository;
import com.proyectos_uts.app.repository.ProyectoRepository;

@Controller
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EvaluadorRepository evaluadorRepository;

    @GetMapping("/listar-proy")
    public String listar(Model model) {
        List<ProyectoEntity> listar = proyectoRepository.findAll();
        model.addAttribute("listarProy", listar);
        return "listarProy";
    }

    @GetMapping("/listar-proy-est/{id}")
    public String listarProyectosPorEstudiante(Model model, @PathVariable Long id) {
        List<ProyectoEntity> listar = proyectoRepository.findAll();
        model.addAttribute("listarProy", listar);
        model.addAttribute("id", id);
        return "listarProyEst";
    }

    @GetMapping("/listar-proy-estu/{id}")
    public String listarProyectosDeEstudiante(Model model, @PathVariable Long id) {
        Optional<EstudianteEntity> estudianteOpt = estudianteRepository.findById(id);
        if (estudianteOpt.isPresent()) {
            EstudianteEntity estudiante = estudianteOpt.get();
            List<ProyectoEntity> listar = proyectoRepository.findByEstudiante(estudiante);
            model.addAttribute("listarProy", listar);
            model.addAttribute("id", id);
        } else {
            model.addAttribute("errorMessage", "Estudiante no encontrado");
        }
        return "listarProyEst";
    }

    @GetMapping("/seleccionar/{id}/{idEst}")
    public String seleccionarProyecto(@PathVariable Long id, @PathVariable Long idEst) {
        Optional<ProyectoEntity> proyectoOpt = proyectoRepository.findById(id);
        Optional<EstudianteEntity> estudianteOpt = estudianteRepository.findById(idEst);

        if (proyectoOpt.isPresent() && estudianteOpt.isPresent()) {
            ProyectoEntity proyectoEntity = proyectoOpt.get();
            proyectoEntity.setEstudiante(estudianteOpt.get());
            proyectoRepository.save(proyectoEntity);
        }

        return "redirect:/home-est/" + idEst;
    }

    @GetMapping("/listar-proy-dir/{id}")
    public String listarProyectosPorDirector(Model model, @PathVariable Long id) {
        Optional<DirectorEntity> directorOpt = directorRepository.findById(id);
        if (directorOpt.isPresent()) {
            DirectorEntity directorEntity = directorOpt.get();
            List<ProyectoEntity> listar = proyectoRepository.findByDirector(directorEntity);
            model.addAttribute("listarProy", listar);
        } else {
            model.addAttribute("errorMessage", "Director no encontrado");
        }
        return "listarProy";
    }

    @GetMapping("/listar-proy-eva/{id}")
    public String listarProyectosPorEvaluador(Model model, @PathVariable Long id) {
        Optional<EvaluadorEntity> evaluadorOpt = evaluadorRepository.findById(id);
        if (evaluadorOpt.isPresent()) {
            EvaluadorEntity evaluadorEntity = evaluadorOpt.get();
            List<ProyectoEntity> listar = proyectoRepository.findByEvaluador(evaluadorEntity);
            model.addAttribute("listarProy", listar);
        } else {
            model.addAttribute("errorMessage", "Evaluador no encontrado");
        }
        return "listarProy";
    }

    @GetMapping("/crearProy")
    public String crear(Model model) {
        model.addAttribute("proy", new ProyectoEntity());
        model.addAttribute("listaDir", directorRepository.findAll());
        model.addAttribute("listaEst", estudianteRepository.findAll());
        model.addAttribute("listaEva", evaluadorRepository.findAll());
        return "formProy";
    }

    @PostMapping("/guardarProy")
    public String guardar(ProyectoEntity proy, RedirectAttributes redirectAttributes) {
        try {
            proyectoRepository.save(proy);
            redirectAttributes.addFlashAttribute("successMessage", "Proyecto guardado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al guardar el proyecto");
        }
        return "redirect:/listar-proy";
    }

    @GetMapping("/editarProy/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<ProyectoEntity> optionalProyecto = proyectoRepository.findById(id);
        if (optionalProyecto.isPresent()) {
            ProyectoEntity proyecto = optionalProyecto.get();
            model.addAttribute("proy", proyecto);
            model.addAttribute("listaDir", directorRepository.findAll());
            model.addAttribute("listaEst", estudianteRepository.findAll());
            model.addAttribute("listaEva", evaluadorRepository.findAll());
        } else {
            model.addAttribute("errorMessage", "Proyecto no encontrado");
        }
        return "formProy";
    }

    @GetMapping("/eliminarProy/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            proyectoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Proyecto eliminado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al eliminar el proyecto");
        }
        return "redirect:/listar-proy";
    }
}
