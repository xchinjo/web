package br.com.bjbraz.dto.account;

import java.io.Serializable;

/**
 * 
 * @author asimas
 *
 */
public class SensorBlockchainDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8572773231768100051L;
	// {"humidity": 52.0, "hora": "09:58:18", "temperature": 24.0, "data":"12/04/2018"}
	private String externalIdentifier;
	private String data;
	private String hora;
	private String temperature;
	private String humidity;

	public String getExternalIdentifier() {
		return externalIdentifier;
	}

	public void setExternalIdentifier(String externalIdentifier) {
		this.externalIdentifier = externalIdentifier;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

}
