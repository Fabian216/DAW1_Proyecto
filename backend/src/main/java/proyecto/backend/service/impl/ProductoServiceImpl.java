package proyecto.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.backend.dto.ProductoDto;
import proyecto.backend.entity.Producto;
import proyecto.backend.repository.ProductoRepository;
import proyecto.backend.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<ProductoDto> getAllProductos() throws Exception {
        List<ProductoDto> productos = new ArrayList<>();
        Iterable<Producto> iterable = productoRepository.findAll();
        iterable.forEach(producto -> {
            ProductoDto productoDto = new ProductoDto(producto.getCodPro(),
                    producto.getNomPro(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getStockPro(),
                    producto.getCatPro());
            productos.add(productoDto);
        });
        return productos;
    }

}
