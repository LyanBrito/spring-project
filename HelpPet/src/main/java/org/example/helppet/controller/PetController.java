package org.example.helppet.controller;

import jakarta.validation.Valid;
import org.example.helppet.dto.PetReqDTO;
import org.example.helppet.services.PetServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {
    private final PetServices petServices;

    public PetController(PetServices petServices) {
        this.petServices = petServices;
    }

    public ResponseEntity<?> savePet(@Valid @RequestBody PetReqDTO req) {
        return ResponseEntity.ok(petServices.savePet(req));
    }
}
