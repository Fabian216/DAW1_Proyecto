package proyecto.backend.repository;

import org.springframework.data.repository.CrudRepository;
import proyecto.backend.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
