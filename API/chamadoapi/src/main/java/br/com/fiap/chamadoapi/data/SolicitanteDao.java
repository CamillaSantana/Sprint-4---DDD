package br.com.fiap.chamadoapi.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.chamadoapi.model.Solicitante;

public class SolicitanteDao {

	private Connection conexao;

    public SolicitanteDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public Long save(Solicitante solicitante) throws SQLException { 
    	var comando = conexao.prepareStatement("INSERT INTO solicitante (nome, sobrenome, email, telefone, cpf, data_nascimento, cep, estado, cidade, logradouro, numero, complemento, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new String[]{"id"});
            comando.setString(1, solicitante.nome());
            comando.setString(2, solicitante.sobrenome());
            comando.setString(3, solicitante.email());
            comando.setString(4, solicitante.telefone());
            comando.setString(5, solicitante.cpf());
            comando.setString(6, solicitante.dataNascimento());
            comando.setString(7, solicitante.cep());
            comando.setString(8, solicitante.estado());
            comando.setString(9, solicitante.cidade());
            comando.setString(10, solicitante.logradouro());
            comando.setString(11, solicitante.numero());
            comando.setString(12, solicitante.complemento());
            comando.setString(13, solicitante.genero());

            comando.executeUpdate();
            
            Long idGerado = (long) 0;
			try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idGerado  = generatedKeys.getLong(1);
                }
			}
			System.out.println("ID SOLICITANTE GERADO:" + idGerado);
            return idGerado;
        
    }
}
