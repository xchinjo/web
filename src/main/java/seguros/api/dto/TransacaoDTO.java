package seguros.api.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import seguros.api.domain.Transacao;

/**
 * 
 * @author alex.braz
 *
 */
public class TransacaoDTO implements Serializable{
	
	public TransacaoDTO(){}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 981684797813806867L;
	
	public TransacaoDTO(Transacao t){
		this.setId(t.getId());
		this.setDataTransacao(getFormatedDate(t.getDataTransacao()));
		this.setDestino(t.getDestino().getNome());
		this.setHash(t.getHash());
		this.setOrigem(t.getOrigem().getNome());
		this.setQtdPontos(t.getQtdPontos().doubleValue());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@JsonSerialize(using=DoubleSerializer.class)
	@JsonProperty("qtdPontos")
	public Double getQtdPontos() {
		return qtdPontos;
	}

	public void setQtdPontos(Double qtdPontos) {
		this.qtdPontos = qtdPontos;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}



	private Long id;

	private String hash;
	
	private String dataTransacao;
	
	private String origem;
	
	private String destino;	
	
	private Double qtdPontos;
	
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String idUsuario;

	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String getFormatedDate(Date time) {

		try {
			
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-02:00"));
			
			return simpleDateFormat.format(time);
			
		} catch (Exception e) {
			return "*Data inválida*";
		}

	}

}
