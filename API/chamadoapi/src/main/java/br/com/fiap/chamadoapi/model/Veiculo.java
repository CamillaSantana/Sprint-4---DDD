package br.com.fiap.chamadoapi.model;

public record Veiculo(
	    Long id,
	    String marcaCarro,
	    String modeloCarro,
	    String placaCarro,
	    String anoCarro,
	    String eixosCarro,
	    String comprimentoCarro,
	    String alturaCarro,
	    String pesoCarro,
	    String chassisCarro
) {
	
}