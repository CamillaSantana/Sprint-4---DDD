package br.com.fiap.chamadoapi.model;

public record Incidente(
	    Long id,
	    String horaIncidente,
	    String estadoIncidente,
	    String cidadeIncidente,
	    String logradouroIncidente,
	    String numeroIncidente,
	    String complementoIncidente,
	    String descricaoIncidente
) {
}
