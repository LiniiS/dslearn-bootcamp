package com.asantos.dslearn.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asantos.dslearn.dto.UserDTO;
import com.asantos.dslearn.entities.User;
import com.asantos.dslearn.repositories.RoleRepository;
import com.asantos.dslearn.repositories.UserRepository;
import com.asantos.dslearn.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {
	// logger
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private AuthService authService;

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public UserDTO findUserById(Long userId) {

		authService.validateSelfOrAdmin(userId);

		Optional<User> optUser = userRepository.findById(userId);
		User userEntity = optUser.orElseThrow(() -> new ResourceNotFoundException("Entity User not found!"));
		return new UserDTO(userEntity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if (null == user) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found!");
		}
		logger.info("User found: " + username);
		return user;
	}

}
