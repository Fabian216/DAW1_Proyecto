package proyecto.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.backend.dto.UserDetailDto;
import proyecto.backend.dto.UserDto;
import proyecto.backend.entity.User;
import proyecto.backend.repository.UserRepository;
import proyecto.backend.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() throws Exception {

        List<UserDto> users = new ArrayList<UserDto>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(user -> users.add(new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail())));
        return users;

    }

    @Override
    public Optional<UserDetailDto> getUserById(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> new UserDetailDto(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getCreated(),
                user.getUpdated()));

    }

    @Override
    public boolean updateUser(UserDto userDto) throws Exception {

        Optional<User> optional = userRepository.findById(userDto.id());
        return optional.map(user -> {
            user.setFirstName(userDto.firstName());
            user.setLastName(userDto.lastName());
            user.setEmail(userDto.email());
            user.setUpdated(new Date());
            userRepository.save(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteUserById(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addUser(UserDetailDto userDetailDto) throws Exception {

        Optional<User> optional = userRepository.findById(userDetailDto.id());
        if (optional.isPresent()) {
            return false;
        } else {
            User user = new User();
            user.setUsername(userDetailDto.username());
            user.setPassword(userDetailDto.password());
            user.setEmail(userDetailDto.email());
            user.setFirstName(userDetailDto.firstName());
            user.setLastName(userDetailDto.lastName());
            user.setRole(userDetailDto.role());
            user.setCreated(new Date());
            userRepository.save(user);
            return true;
        }

    }

}
