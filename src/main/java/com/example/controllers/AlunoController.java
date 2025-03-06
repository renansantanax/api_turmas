package com.example.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.AlunoRequestDto;
import com.example.entities.Aluno;
import com.example.repositories.AlunoRepository;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {

	@Operation(summary = "Serviço para cadastrar alunos.")
	@PostMapping("cadastrar")
	public String cadastrar(@RequestBody @Valid AlunoRequestDto request) {

		System.out.println("Recebendo dados do aluno: " + request.getNome() + ", " + request.getMatricula() + ", "
				+ request.getCpf());

		var aluno = new Aluno();

		aluno.setId(UUID.randomUUID());
		aluno.setNome(request.getNome());
		aluno.setMatricula(request.getMatricula());
		aluno.setCpf(request.getCpf());

		var alunoRepository = new AlunoRepository();
		alunoRepository.create(aluno);

		return "Aluno cadastrado com sucesso.";

	}

	@Operation(summary = "Serviço para atualizar alunos.")
	@PutMapping("atualizar/{id}")
	public String atualizar(@PathVariable UUID id, @RequestBody @Valid AlunoRequestDto request) {

		var aluno = new Aluno();

		aluno.setId(id);
		aluno.setNome(request.getNome());
		aluno.setMatricula(request.getMatricula());
		aluno.setCpf(request.getCpf());

		var alunoRepository = new AlunoRepository();
		alunoRepository.update(aluno);

		return "Aluno atualizado com sucesso.";
	}

	@Operation(summary = "Serviço para excluir alunos.")
	@DeleteMapping("excluir/{id}")
	public String excluir(UUID id) {

		var alunoRepository = new AlunoRepository();
		alunoRepository.delete(id);

		return "Aluno excluído com sucesso.";

	}
	
	@Operation(summary = "Serviço para consultar todos os alunos.")
	@GetMapping("consultar")
	public List<Aluno> consultar() {
		
		var alunoRepository = new AlunoRepository();
		return alunoRepository.findAll();
	}
	
	@Operation(summary = "Serviço para consultar todos os alunos.")
	@GetMapping("consultar/{id}")
	public Aluno consultarId(@PathVariable UUID id) {
		
		var alunoRepository = new AlunoRepository();
		return alunoRepository.findById(id);
	}
	
	
}
