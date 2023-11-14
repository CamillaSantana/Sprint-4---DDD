package br.com.fiap.chamadoapi.service;

import java.sql.SQLException;

import br.com.fiap.chamadoapi.data.VeiculoDao;
import br.com.fiap.chamadoapi.model.Veiculo;

public class VeiculoService {

	private VeiculoDao veiculoDao;
	
    public boolean save(Veiculo veiculo) {
        try {
        	veiculoDao = new VeiculoDao();
            veiculoDao.save(veiculo);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
