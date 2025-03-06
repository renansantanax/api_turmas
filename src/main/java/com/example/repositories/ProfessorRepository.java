package com.example.repositories;

import com.example.entities.Professor;
import com.example.factories.ConnectionFactory;

public class ProfessorRepository {

	private ConnectionFactory connectionFactory = new ConnectionFactory();

	public void create(Professor professor) {

		try {

			var connection = connectionFactory.getConnection();
			var statement = connection.prepareStatement("INSERT INTO professor(id, nome, telefone) VALUES (?,?,?)");
			statement.setObject(1, professor.getId());
			statement.setString(2, professor.getNome());
			statement.setString(3, professor.getTelefone());
			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void update(Professor professor) {
		
		try {
			var connection = connectionFactory.getConnection();
			var statement = connection.prepareStatement("UPDATE professor SET nome=?, telefone=? WHERE id=?");
			statement.setString(1, professor.getNome());
			statement.setString(2, professor.getTelefone());
			statement.setObject(3, professor.getId());
			statement.execute();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
