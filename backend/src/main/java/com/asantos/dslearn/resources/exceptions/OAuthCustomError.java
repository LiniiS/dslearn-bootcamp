package com.asantos.dslearn.resources.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Classe auxiliar para retornar o erro nos moldes da implementação padrão do OAuth
 * @author linis
 *
 */
public class OAuthCustomError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;

	// ao serializar será convertido pra camel_case, conforme o erro padrão do OAuth
	@JsonProperty("error_description")
	private String errorDescription;

	public OAuthCustomError() {
	}

	public OAuthCustomError(String error, String errorDescription) {
		super();
		this.error = error;
		this.errorDescription = errorDescription;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
