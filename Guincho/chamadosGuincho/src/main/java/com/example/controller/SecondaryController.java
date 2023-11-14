package com.example.controller;

import java.io.IOException;

import com.example.App;
import com.example.data.ChamadoDao;
import com.example.model.Chamado;
import com.example.model.Incidente;
import com.example.model.Solicitante;
import com.example.model.Veiculo;
import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SecondaryController {

    //Atributos do solicitante
    @FXML TextField txtNomeSolicitante;
    @FXML TextField txtSobrenomeSolicitante;
    @FXML TextField txtEmailSolicitante;
    @FXML TextField txtTelefoneSolicitante;
    @FXML TextField txtCPFSolicitante;
    @FXML TextField dataNascSolicitante;
    @FXML TextField txtCEPSolicitante;
    @FXML TextField txtEstadoSolicitante;
    @FXML TextField txtCidadeSolicitante;
    @FXML TextField txtLogradouroSolicitante;
    @FXML TextField txtNumeroSolicitante;
    @FXML TextField txtComplementoSolicitante;
    @FXML RadioButton rbGenFeminSolicitante;
    @FXML RadioButton rbGenMascSolicitante;
    @FXML RadioButton rbGenOutrosSolicitante;
    @FXML RadioButton rbGenNullSolicitante;

    //Atributos do carro
    @FXML TextField txtMarcaCarro;
    @FXML TextField txtModeloCarro;
    @FXML TextField txtPlacaCarro;
    @FXML TextField txtAnoCarro;
    @FXML TextField txtEixosCarro;
    @FXML TextField txtComprimentoCarro;
    @FXML TextField txtAlturaCarro;
    @FXML TextField txtPesoCarro;
    @FXML TextField txtChassiCarro;

    //Atributos do incidente
    @FXML TextField txtHoraIncidente;
    @FXML TextField txtEstadoIncidente;
    @FXML TextField txtCidadeIncidente;
    @FXML TextField txtLogradouroIncidente;
    @FXML TextField txtNumeroLocalIncidente;
    @FXML TextField txtComplementoLocalIncidente;
    @FXML TextArea txtDescricaoIncidente;

    private ChamadoDao chamadoDao = new ChamadoDao();

    public void adicionarChamado(){
        try {
            Chamado chamado = criarChamado();
            chamadoDao.enviarChamado(chamado);
            mostraMensagemSucesso();
            switchToPrimary();;
        } catch (IOException | InterruptedException e) {
            mostrarMensagemErro("Erro!", "Não foi possível concluir sua solicitação." );
        }
       
    }
    
    private Chamado criarChamado() throws JsonProcessingException{
        Solicitante solicitante = new Solicitante(null, txtNomeSolicitante.getText(), txtSobrenomeSolicitante.getText(), txtEmailSolicitante.getText(), txtTelefoneSolicitante.getText(), txtCPFSolicitante.getText(), dataNascSolicitante.getText(), txtCEPSolicitante.getText(), txtEstadoSolicitante.getText(), txtCidadeSolicitante.getText(), txtLogradouroSolicitante.getText(), txtNumeroSolicitante.getText(), txtComplementoSolicitante.getText(), (rbGenFeminSolicitante.isSelected()?"Feminino":rbGenMascSolicitante.isSelected()?"Masculino":rbGenOutrosSolicitante.isSelected()?"Outros":rbGenNullSolicitante.isSelected()?"Prefiro não informar":null));
        Veiculo veiculo = new Veiculo(null, txtMarcaCarro.getText(), txtModeloCarro.getText(), txtPlacaCarro.getText(), txtAnoCarro.getText(), txtEixosCarro.getText(), txtComprimentoCarro.getText(), txtAlturaCarro.getText(), txtPesoCarro.getText(), txtChassiCarro.getText());
        Incidente incidente = new Incidente(null, txtHoraIncidente.getText(), txtEstadoIncidente.getText(), txtCidadeIncidente.getText(), txtLogradouroIncidente.getText(), txtNumeroLocalIncidente.getText(), txtComplementoLocalIncidente.getText(), txtDescricaoIncidente.getText());
        return new Chamado(null, solicitante, veiculo, incidente);
        
    }
  
    private void mostrarMensagemErro(String titulo, String mensagem){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }


    public void mostraMensagemSucesso(){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Aviso");
        alerta.setHeaderText("Solicitação Modal");
        alerta.setContentText("Seus dados foram coletados e em breve a seguradora entrará em contato com você. Clique em 'Ok' para prosseguir.");
        
        alerta.showAndWait();
    }

    @FXML
    public void switchToPrimary() throws IOException{
        App.setRoot("primary");
    }
    
}