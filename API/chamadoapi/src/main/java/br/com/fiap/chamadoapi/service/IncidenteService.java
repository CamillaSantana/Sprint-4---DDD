package br.com.fiap.chamadoapi.service;

import java.sql.SQLException;

import br.com.fiap.chamadoapi.data.IncidenteDao;
import br.com.fiap.chamadoapi.model.Incidente;

public class IncidenteService {

	private IncidenteDao incidenteDao;

    public boolean save(Incidente incidente) {
        try {
            incidenteDao = new IncidenteDao();
            incidenteDao.save(incidente);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
