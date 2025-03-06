package com.example.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Turma {

	private UUID id;
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Professor professor;
	private List<Matricula> matriculas;
	
}
