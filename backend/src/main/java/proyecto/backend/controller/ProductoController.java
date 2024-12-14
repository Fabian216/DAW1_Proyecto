package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.backend.dto.ProductoDto;
import proyecto.backend.service.ProductoService;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/productoslist")
    public String start (Model model){
        try {
            List<ProductoDto> productos = productoService.getAllProductos();
            model.addAttribute("productos", productos);
            model.addAttribute("error", "");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error al obtener los datos del producto");
        }
        return "producto/productos_lista";
    }

}
