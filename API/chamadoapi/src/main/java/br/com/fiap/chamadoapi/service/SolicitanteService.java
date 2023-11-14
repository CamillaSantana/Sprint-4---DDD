package br.com.fiap.chamadoapi.service;

import java.sql.SQLException;

import br.com.fiap.chamadoapi.data.SolicitanteDao;
import br.com.fiap.chamadoapi.model.Solicitante;

public class SolicitanteService {

	private SolicitanteDao solicitanteDao;

    public boolean save(Solicitante solicitante) {
        try {
            solicitanteDao = new SolicitanteDao();
            solicitanteDao.save(solicitante);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
