package org.example.helppet.services;

import jakarta.validation.Valid;
import org.example.helppet.dto.PetReqDTO;
import org.example.helppet.dto.PetResDTO;
import org.example.helppet.entity.Pet;
import org.example.helppet.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetServices {
    private final PetRepository petRepo;

    public PetServices(PetRepository petRepo) {
        this.petRepo = petRepo;
    }

    public PetResDTO savePet(@Valid PetReqDTO req){
        Pet pet = new Pet(req);
        petRepo.save(pet);
        return new PetResDTO(pet);
    }

}