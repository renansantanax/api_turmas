package com.example.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.ProfessorCreateDto;
import com.example.dtos.ProfessorUpdateDto;
import com.example.entities.Professor;
import com.example.repositories.ProfessorRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/professor")
public class ProfessorController {

	private ProfessorRepository repository = new ProfessorRepository();
	
	@Operation(summary = "Serviço para cadastrar professor")
	@PostMapping("cadastrar")
	public void cadastrar(@RequestBody ProfessorCreateDto request) {

		var professor = new Professor();

		professor.setId(UUID.randomUUID());
		professor.setNome(request.getNome());
		professor.setTelefone(request.getTelefone());

		repository.create(professor);

	}

	@Operation(summary = "Serviço para atualizar professor")
	@PutMapping("atualizar")
	public void atualizar(@RequestBody ProfessorUpdateDto request) {

		var professor = new Professor();
		
		professor.setId(request.getId());
		professor.setNome(request.getNome());
		professor.setTelefone(request.getTelefone());

		repository.update(professor);
		
	}
}
