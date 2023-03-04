package com.asantos.dslearn.services.exceptions;

/**
 * Retornará 403, quando o usuário está autenticado mas não autorizado
 * @author linis
 *
 */

public class ForbiddenException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);
	}

}
