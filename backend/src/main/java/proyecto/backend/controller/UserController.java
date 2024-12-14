package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.backend.dto.UserDto;
import proyecto.backend.service.UserService;

import java.util.List;

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

}
