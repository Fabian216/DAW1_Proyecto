package proyecto.backend.service;

import proyecto.backend.dto.ProductoDto;

import java.util.List;

public interface ProductoService {

    List<ProductoDto> getAllProductos() throws Exception;

}
