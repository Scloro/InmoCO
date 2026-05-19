package InmoCO.controller;

import InmoCO.model.Inmueble;
import InmoCO.service.InmuebleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InmuebleController {

    private final InmuebleService inmuebleService;

    public InmuebleController(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/inmuebles")
    public String listarInmuebles(Model model) {
        model.addAttribute("inmuebles", inmuebleService.listarTodos());
        return "inmuebles/lista";
    }

    @GetMapping("/inmuebles/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("inmueble", new Inmueble());
        return "inmuebles/formulario";
    }

    @PostMapping("/inmuebles")
    public String guardarInmueble(@ModelAttribute Inmueble inmueble) {
        inmuebleService.guardarInmueble(inmueble);
        return "redirect:/inmuebles";
    }

    @GetMapping("/inmuebles/editar/{id}")
    public String editarInmueble(@PathVariable Long id, Model model) {
        Inmueble inmueble = inmuebleService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));
        model.addAttribute("inmueble", inmueble);
        return "inmuebles/formulario";
    }

    @GetMapping("/inmuebles/eliminar/{id}")
    public String eliminarInmueble(@PathVariable Long id) {
        inmuebleService.eliminarInmueble(id);
        return "redirect:/inmuebles";
    }
}