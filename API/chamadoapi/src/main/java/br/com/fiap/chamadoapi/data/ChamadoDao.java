package br.com.fiap.chamadoapi.data;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.chamadoapi.model.Chamado;

public class ChamadoDao {
	
	private Connection conexao;

    public ChamadoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
	
    public void save(Chamado chamado) throws SQLException {
        var comando = conexao.prepareStatement("INSERT INTO chamado (veiculo_id,solicitante_id, incidente_id) VALUES (?, ?, ?)");
        comando.setLong(1, chamado.veiculo().id());
        comando.setLong(2, chamado.solicitante().id());
        comando.setLong(3, chamado.incidente().id());

        comando.executeUpdate();
    }

	
}
