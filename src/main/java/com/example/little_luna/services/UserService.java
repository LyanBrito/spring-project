package com.example.little_luna.services;

import com.example.little_luna.dto.UserRequestDTO;
import com.example.little_luna.dto.UserResponseDTO;
import com.example.little_luna.entity.User;
import com.example.little_luna.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO save(UserRequestDTO user) {
        User u = new User(user.getNome(), user.getEmail(), user.getSenha());
        userRepository.save(u);
        return new UserResponseDTO(u);
    }

    public String login(User user) {
        User findUser = userRepository.findByEmail(user.getEmail());
        if (findUser == null) {
            return "Usuario não encontrado!";
        } else {
            if (user.getSenha().equals(findUser.getSenha())) {
                return "Login com sucesso!";
            } else {
                return "Senha Incorreta!";
            }
        }
    }

    public List<UserResponseDTO> findAll() {
        System.out.println("Users mostrados com sucesso");
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTO = new ArrayList<>();

        for (User user : users) {
            userResponseDTO.add(new UserResponseDTO(user));
        }
        return userResponseDTO;
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    public String deletarPorId(int id) {
        userRepository.deleteById(id);
        if (!userRepository.existsById(id)) {
            return "Deletado com sucesso!";
        } else {
            return "User não deletado";
        }
    }
    public String atualizarPorId(int id, User user) {
        Optional<User> UserExisty = userRepository.findById(id);

        if (UserExisty.isPresent()) {
            User u = UserExisty.get();
            u.setNome(user.getNome());
            u.setEmail(user.getEmail());
            u.setSenha(user.getSenha());
            userRepository.save(u);
            return u.toString();
        } else {
            return "User bnot found";
        }
    }
}

