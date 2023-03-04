package com.asantos.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asantos.dslearn.entities.User;
import com.asantos.dslearn.repositories.UserRepository;
import com.asantos.dslearn.services.exceptions.ForbiddenException;
import com.asantos.dslearn.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	private static final String ADMIN = "ROLE_ADMIN";
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)//operação somente de leitura, não trava o banco
	public User authenticatedUser() {

		try {
			// retorna o nome o do usuário que está autenticado
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid User");
		}
	}
	
	/**
	 * Verifica se o usuário que está logado é o mesmo que está sendo consultado e qual é o Role
	 * se:
	 * <ul>
	 * 	 <li>id do usuário logado é o mesmo do usuário consultado e ele não é <i>ADMIN</i>:<br> - deve visualizar apenas o seu perfil de usuário <br> - HttpStatus: 200</li>
	 * 	 <li>id do usuário logado é o mesmo do usuário consultado e ele é <i>ADMIN</i>:<br> - deve permitir a visualizaçaõ de todos os perfis de usuários <br> - HttpStatus: 200</li>
	 * 	 <li>id do usuário logado não é o mesmo do usuário consultado e ele não é <i>ADMIN</i>:<br> - não deve permitir a visualização do perfil do usuário <br> - HttpStatus: 403</li>	
	 * </ul>
	 * @param userId
	 * @return Acesso negado || Usuário 
	 */
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticatedUser();
		
		if (!user.getId().equals(userId) && !user.hasRole(ADMIN)) {
			throw new ForbiddenException("Access denied");
		}
	}
}
