package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.backend.dto.ProductoDto;
import proyecto.backend.service.ProductoService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/detalle/{id}")
    public String getProductoById(@PathVariable("id") int id, Model model) {
        try {
            Optional<ProductoDto> producto = productoService.getProductoById(id);

            if (producto.isPresent()) {
                model.addAttribute("producto", producto.get());
                model.addAttribute("error", "");
            } else {
                model.addAttribute("error", "No se encontró el producto con ID: " + id);
                return "producto/producto_no_encontrado"; // Vista para producto no encontrado
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los detalles del producto");
            return "producto/error"; // Vista para errores generales
        }
        return "producto/producto_detalle"; // Vista para mostrar el detalle del producto
    }




}
