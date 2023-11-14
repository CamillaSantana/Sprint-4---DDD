package br.com.fiap.chamadoapi.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.chamadoapi.model.Incidente;

public class IncidenteDao {

	private Connection conexao;

    public IncidenteDao() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public Long save(Incidente incidente) throws SQLException {
    	var comando = conexao.prepareStatement("INSERT INTO incidente (hora_incidente, estado_incidente, cidade_incidente, logradouro_incidente, numero_incidente, complemento_incidente, descricao_incidente) VALUES (?, ?, ?, ?, ?, ?, ?)", new String[]{"id"});
            comando.setString(1, incidente.horaIncidente());
            comando.setString(2, incidente.estadoIncidente());
            comando.setString(3, incidente.cidadeIncidente());
            comando.setString(4, incidente.logradouroIncidente());
            comando.setString(5, incidente.numeroIncidente());
            comando.setString(6, incidente.complementoIncidente());
            comando.setString(7, incidente.descricaoIncidente());

            comando.executeUpdate();
           
            Long idGerado = (long) 0;
			try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idGerado  = generatedKeys.getLong(1);
                }
			}
			System.out.println("ID INCIDENTE GERADO:" + idGerado);
            return idGerado;
            
      }
    
    
    
}
