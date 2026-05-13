package com.images.controller;

import com.images.services.PhotoService;
import com.images.services.UsersServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersServices userS;
    private final PhotoService photoS;

    public UsersController(UsersServices userS, PhotoService photoS) {
        this.userS = userS;
        this.photoS = photoS;
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam MultipartFile photo) throws IOException {
        String pathPhoto = photoS.savePhoto(photo);
        return ResponseEntity.ok(userS.saveUser(name, email, pathPhoto));
    }
}
