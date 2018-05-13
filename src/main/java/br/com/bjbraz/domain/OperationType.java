package br.com.bjbraz.domain;

public enum OperationType {
	CRIACAO_DE_CONTA("CREATE_ACCOUNT","CREATE_ACCOUNT"),
	CONSULTA_DE_SALDO("BALANCE","BALANCE"),
	TRANSFERENCIA("TRANSFER","TRANSFER");
	
	private String nome;
	private String descricao;
	
	OperationType(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static OperationType getTipo(String nome) throws Exception{
		OperationType retorno;
		
		switch(nome){
			case "CREATE_ACCOUNT": retorno = CRIACAO_DE_CONTA;
				break;
			case "BALANCE":retorno = CONSULTA_DE_SALDO;
				break;
			case "TRANSFER":retorno = TRANSFERENCIA;
				break;
			default: throw new IllegalArgumentException("Event not identified.");
		}
		return retorno;
	}
}
