package com.asantos.dslearn.services.exceptions;

/**
 * Retornará 401, quando o usuário não possuir as credenciais pra acessar o
 * recurso
 * 
 * @author linis
 *
 */
public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String msg) {
		super(msg);
	}

}
