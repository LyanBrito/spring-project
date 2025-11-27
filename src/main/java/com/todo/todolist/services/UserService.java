package com.todo.todolist.services;

import com.todo.todolist.dto.UserRequestDTO;
import com.todo.todolist.dto.UserResponseDTO;
import com.todo.todolist.entiryModel.User;
import com.todo.todolist.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String login(User user) {
        User findUser = userRepo.findByEmail(user.getEmail());
        if (findUser == null) {
            return "Usuario não encontrado!";
        } else {
            if (user.getPassword().equals(findUser.getPassword())) {
                return "Login com sucesso!";
            } else {
                return "Senha Incorreta!";
            }
        }
    }

    public UserResponseDTO save(UserRequestDTO req) {
        User u = new User(req.getName(), req.getEmail(), req.getPassword());
        userRepo.save(u);
        return new UserResponseDTO(u);
    }


    public List<UserResponseDTO> findAll() {
        System.out.println("Users mostrados com sucesso");
        List<User> users = userRepo.findAll();
        List<UserResponseDTO> userResponseDTO = new ArrayList<>();

        for (User user : users) {
            userResponseDTO.add(new UserResponseDTO(user));
        }
        return userResponseDTO;
    }

    public Optional<User> getById(long id) {
        return Optional.ofNullable(userRepo.findById(id));
    }

    public String deleteById(long id) {
        userRepo.deleteById(id);
        if (!userRepo.existsById(id)) {
            return "Deletado com sucesso!";
        } else {
            return "User não deletado";
        }
    }

    public String updateById(Long id, User user) {
        Optional<User> isUser = userRepo.findById(id);

        if (isUser.isPresent()) {
            User u = isUser.get();
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            userRepo.save(u);
            return u.toString();
        } else {
            return "User bnot found";
        }
    }
}
