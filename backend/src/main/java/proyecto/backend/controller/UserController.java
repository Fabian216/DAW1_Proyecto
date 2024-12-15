package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.dto.UserDetailDto;
import proyecto.backend.dto.UserDto;
import proyecto.backend.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/manage")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/restricted")
    public String restricted(Model model) {
        return "restricted";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "manage-add";
    }

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<UserDto> users = userService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los datos");

        }
        return "manage";
    }

    @GetMapping("/detail/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        try {
            Optional<UserDetailDto> user = userService.getUserById(id);

            if (user.isPresent()) {
                model.addAttribute("user", user.get());
                model.addAttribute("error", null);
            } else {
                model.addAttribute("error", "No se encontró el usuario con ID: " + id);
                return "user-not-found"; // Vista específica para usuario no encontrado
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los detalles del usuario");
            return "error"; // Vista para errores generales
        }
        return "user-detail"; // Vista para mostrar el detalle del usuario
    }


}
