package com.proyectos_uts.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectos_uts.app.entity.AdministradorEntity;
import com.proyectos_uts.app.entity.CoordinadorEntity;
import com.proyectos_uts.app.entity.DirectorEntity;
import com.proyectos_uts.app.entity.EstudianteEntity;
import com.proyectos_uts.app.entity.EvaluadorEntity;
import com.proyectos_uts.app.entity.LoginUser;
import com.proyectos_uts.app.repository.AdministradorRepository;
import com.proyectos_uts.app.repository.CoordinadorRepository;
import com.proyectos_uts.app.repository.DirectorRepository;
import com.proyectos_uts.app.repository.EstudianteRepository;
import com.proyectos_uts.app.repository.EvaluadorRepository;

@Controller
public class HomeController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EvaluadorRepository evaluadorRepository;

    // Muestra el index.html como página principal
    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    // Ruta para el formulario de login
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new LoginUser());
        return "login";
    }

    // Verifica si una cadena es un número
    public boolean esNumero(String strNum) {
        try {
            Long.parseLong(strNum);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    // Proceso de autenticación en el login
    @PostMapping("/loguearse")
    public String loguearse(LoginUser usuario, Model model) {
        Long idAdmin = null;
        Long idCoor = null;
        Long idDir = null;
        Long idEst = null;
        Long idEva = null;

        // Verificar si el usuario ingresado es un número (cédula)
        if (esNumero(usuario.getUsuario())) {
            DirectorEntity director = directorRepository.findByCedulaAndContra(Long.parseLong(usuario.getUsuario()), usuario.getContra());
            if (director != null) {
                idDir = director.getCedula();
            }

            CoordinadorEntity coordinador = coordinadorRepository.findByCedulaAndContra(Long.parseLong(usuario.getUsuario()), usuario.getContra());
            if (coordinador != null) {
                idCoor = coordinador.getCedula();
            }

            EstudianteEntity estudiante = estudianteRepository.findByCedulaAndContra(Long.parseLong(usuario.getUsuario()), usuario.getContra());
            if (estudiante != null) {
                idEst = estudiante.getCedula();
            }

            EvaluadorEntity evaluador = evaluadorRepository.findByCedulaAndContra(Long.parseLong(usuario.getUsuario()), usuario.getContra());
            if (evaluador != null) {
                idEva = evaluador.getCedula();
            }
        } else {
            AdministradorEntity admin = administradorRepository.findByUsuarioAndContra(usuario.getUsuario(), usuario.getContra());
            if (admin != null) {
                idAdmin = admin.getId();
            }
        }

        // Redirigir según el rol encontrado
        if (idAdmin != null) {
            return "redirect:/home-admin/" + idAdmin;
        }

        if (idCoor != null) {
            return "redirect:/home-coor/" + idCoor;
        }

        if (idDir != null) {
            return "redirect:/home-dir/" + idDir;
        }

        if (idEst != null) {
            return "redirect:/home-est/" + idEst;
        }

        if (idEva != null) {
            return "redirect:/home-eva/" + idEva;
        }

        // Si no se encuentra coincidencia, redirigir al login
        return "login";
    }
}
