package br.com.fiap.chamadoapi.model;

public record Solicitante(
	    Long id,
	    String nome,
	    String sobrenome,
	    String email,
	    String telefone,
	    String cpf,
	    String dataNascimento,
	    String cep,
	    String estado,
	    String cidade,
	    String logradouro,
	    String numero,
	    String complemento,
	    String genero
) {}
