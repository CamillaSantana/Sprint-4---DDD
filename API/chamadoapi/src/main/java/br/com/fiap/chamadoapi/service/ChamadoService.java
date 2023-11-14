package br.com.fiap.chamadoapi.service;

import java.sql.SQLException;
import br.com.fiap.chamadoapi.data.ChamadoDao;
import br.com.fiap.chamadoapi.data.IncidenteDao;
import br.com.fiap.chamadoapi.data.SolicitanteDao;
import br.com.fiap.chamadoapi.data.VeiculoDao;
import br.com.fiap.chamadoapi.model.Chamado;
import br.com.fiap.chamadoapi.model.Incidente;
import br.com.fiap.chamadoapi.model.Solicitante;
import br.com.fiap.chamadoapi.model.Veiculo;

public class ChamadoService {

	
    private SolicitanteDao solicitanteDao;
    private VeiculoDao veiculoDao;
    private IncidenteDao incidenteDao;
	private ChamadoDao chamadoDao;


    public boolean save(Chamado chamado) {
        try {
        	solicitanteDao = new SolicitanteDao();
            veiculoDao = new VeiculoDao();
            incidenteDao = new IncidenteDao();
            chamadoDao = new ChamadoDao();
        
            Long idSolicitante = solicitanteDao.save(chamado.solicitante());
            Long idVeiculo = veiculoDao.save(chamado.veiculo());
            Long idIncidente = incidenteDao.save(chamado.incidente());
            
            chamado = new Chamado(null,
            		new Solicitante(idSolicitante, chamado.solicitante().nome(), chamado.solicitante().sobrenome(), chamado.solicitante().email(), chamado.solicitante().telefone(), chamado.solicitante().cpf(), chamado.solicitante().dataNascimento(), chamado.solicitante().cep(), chamado.solicitante().estado(), chamado.solicitante().cidade(), chamado.solicitante().logradouro(), chamado.solicitante().numero(), chamado.solicitante().complemento(), chamado.solicitante().genero()),
            		new Veiculo(idVeiculo, chamado.veiculo().marcaCarro(), chamado.veiculo().modeloCarro(), chamado.veiculo().placaCarro(), chamado.veiculo().anoCarro(), chamado.veiculo().eixosCarro(), chamado.veiculo().comprimentoCarro(), chamado.veiculo().alturaCarro(), chamado.veiculo().pesoCarro(), chamado.veiculo().chassisCarro()),
            		new Incidente(idIncidente, chamado.incidente().horaIncidente(), chamado.incidente().estadoIncidente(), chamado.incidente().cidadeIncidente(), chamado.incidente().logradouroIncidente(), chamado.incidente().numeroIncidente(), chamado.incidente().complementoIncidente(), chamado.incidente().descricaoIncidente()));
            
            chamadoDao.save(chamado);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
