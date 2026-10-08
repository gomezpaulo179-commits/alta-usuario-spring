package com.example.altausuariospring.controler;


import com.example.altausuariospring.service.AltaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AltaController {

    //------------------ inyeccion de dependencias por propiedad --------------------
    // aqui si es obligatorio indicar @Autowired
    //no lo vamos a utilizar
//    @Autowired
//    private AltaService altaService;
//





    //----------------------------inyeccion de dependecias por constructor -----------------------
    //razones por las que usar inyeccion por construccion
    //1. cuando spring carga el controlador, sabe por constructor las dependencias que tiene el controlador
//    2. en un test unitario basta con pasar la depencia, por ejemplo un mock.
    //AltaController c = new AltaController(mockService)

    //una vez intsanciado no cambia
    private final AltaService service;

    // Inyección por constructor: NO hacemos new OpcionesService(), nos lo da Spring
    public AltaController(AltaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";              // → templates/index.html
    }

    @GetMapping("/alta")
    public String mostrarFormulario(Model model) {
        // 1. Añadir al modelo las listas de tecnologías y niveles
        model.addAttribute("niveles", service.getNiveles());
        model.addAttribute("tecnologias", service.getTecnologias());
        // 2. Devolver el nombre de la vista
        return "formulario";
    }

    @PostMapping("/alta")
    public String procesarFormulario(@RequestParam String nombre,
                                     @RequestParam String email,
                                     @RequestParam String tecnologia,
                                     @RequestParam(name = "nivel", required = false) List<String> niveles,
                                     Model model) {
        // 1. Si nombre está vacío → mensajeError + datos introducidos + listas → "formulario"
        // 2. Si no → datos al modelo → "confirmacion"
        return "formulario";
    }
}
