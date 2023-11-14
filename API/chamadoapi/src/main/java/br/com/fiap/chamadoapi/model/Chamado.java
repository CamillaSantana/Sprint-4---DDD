package br.com.fiap.chamadoapi.model;

public record Chamado(
		Long id,
		Solicitante solicitante,
		Veiculo veiculo,
		Incidente incidente	
) {}
