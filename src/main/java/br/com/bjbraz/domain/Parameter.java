package br.com.bjbraz.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author asimas
 *
 */
@Entity
@Table(name = "parameters")
public class Parameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3971901855681255243L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private Long id;	
	
	@Column(name = "chave")
	private String chave;
	
	@Column(name = "vlr")
	private String valor;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
