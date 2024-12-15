package proyecto.backend.service;

import proyecto.backend.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<ProductoDto> getAllProductos() throws Exception;

    Optional<ProductoDto> getProductoById(int id) throws Exception;

}
