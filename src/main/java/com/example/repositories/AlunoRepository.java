package com.example.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.entities.Aluno;
import com.example.factories.ConnectionFactory;

public class AlunoRepository {

	private ConnectionFactory connectionFactory = new ConnectionFactory();

	public void create(Aluno aluno) {

		try {

			var connection = connectionFactory.getConnection();
			var statement = connection.prepareStatement("INSERT INTO aluno(id, nome, matricula, cpf) VALUES (?,?,?,?)");
			statement.setObject(1, aluno.getId());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getMatricula());
			statement.setString(4, aluno.getCpf());

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Aluno aluno) {

		try {

			var connection = connectionFactory.getConnection();

			var statement = connection.prepareStatement("UPDATE aluno SET nome=?, matricula=?, cpf=? WHERE id=?");
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getMatricula());
			statement.setString(3, aluno.getCpf());
			statement.setObject(4, aluno.getId());
			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(UUID id) {

		try {
			var connection = connectionFactory.getConnection();
			var statement = connection.prepareStatement("DELETE FROM aluno WHERE id=?");
			statement.setObject(1, id);
			statement.execute();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Aluno> findAll() {

		try {

			var connection = connectionFactory.getConnection();
			var statement = connection.prepareStatement("SELECT * FROM aluno ORDER BY nome");
			var result = statement.executeQuery();

			var list = new ArrayList<Aluno>();

			while (result.next()) {

				var aluno = new Aluno();

				aluno.setId(UUID.fromString(result.getString("id")));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));

				list.add(aluno);

			}
			connection.close();

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Aluno findById(UUID id) {
		
		try {
			
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT aluno.id, aluno.nome, aluno.matricula, aluno.cpf  FROM aluno WHERE aluno.id = ?;");
			statement.setObject(1, id);
			var result = statement.executeQuery();
			
			Aluno aluno = null;
			
			if(result.next()) {
				aluno = new Aluno();
				
				aluno.setId(UUID.fromString(result.getString("id")));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));
				
			}
			
			connection.close();
			
			return aluno;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
