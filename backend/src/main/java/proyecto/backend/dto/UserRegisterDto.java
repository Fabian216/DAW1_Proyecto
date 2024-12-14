package proyecto.backend.dto;

public record UserRegisterDto(Integer id,
                              String username,
                              String password,
                              String email,
                              String firstName,
                              String lastName,
                              String role) {
}
