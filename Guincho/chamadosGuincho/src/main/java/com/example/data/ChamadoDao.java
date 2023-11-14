package com.example.data;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.example.model.Chamado;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChamadoDao {

    public void enviarChamado(Chamado chamadoNovo) throws IOException, InterruptedException{

    ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(chamadoNovo);

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/chamadoapi/webapi/chamado/"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        // Verifique o código de resposta
        int statusCode = response.statusCode();
        if (statusCode == 200 || statusCode == 201) {
            System.out.println("Chamado enviado com sucesso!");
        } else {
            System.out.println("Falha ao enviar o chamado. Código de resposta: " + statusCode);
            System.out.println("Resposta: " + response.body());
        }
    }
}
