package proyecto.backend.dto;

public record ProductoDto(Integer cod_pro,
                          String nom_pro,
                          String descripcion,
                          Double precio,
                          Integer stock_pro,
                          String cat_pro) {
}
