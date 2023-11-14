package br.com.fiap.chamadoapi.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.chamadoapi.model.Veiculo;

public class VeiculoDao {

	private Connection conexao;

    public VeiculoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public Long save(Veiculo veiculo) throws SQLException {
    	var comando = conexao.prepareStatement("INSERT INTO veiculo (marca_carro, modelo_carro, placa_carro, ano_carro, eixos_carro, comprimento_carro, altura_carro, peso_carro, chassis_carro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", new String[]{"id"});
            comando.setString(1, veiculo.marcaCarro());
            comando.setString(2, veiculo.modeloCarro());
            comando.setString(3, veiculo.placaCarro());
            comando.setString(4, veiculo.anoCarro());
            comando.setString(5, veiculo.eixosCarro());
            comando.setString(6, veiculo.comprimentoCarro());
            comando.setString(7, veiculo.alturaCarro());
            comando.setString(8, veiculo.pesoCarro());
            comando.setString(9, veiculo.chassisCarro());

            comando.executeUpdate();
            
            Long idGerado = (long) 0;
			try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idGerado  = generatedKeys.getLong(1);
                }
			}
			System.out.println("ID VEICULO GERADO:" + idGerado);
            return idGerado;
        }

}
