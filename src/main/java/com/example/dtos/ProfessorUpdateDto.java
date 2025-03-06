package com.example.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorUpdateDto {

	private UUID id;
	private String nome;
	private String telefone;
	
}
