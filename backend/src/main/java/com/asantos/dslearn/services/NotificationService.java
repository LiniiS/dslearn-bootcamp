package com.asantos.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asantos.dslearn.dto.NotificationDTO;
import com.asantos.dslearn.entities.Notification;
import com.asantos.dslearn.entities.User;
import com.asantos.dslearn.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly=true)
	public Page <NotificationDTO> notificationsForCurrentUser(Pageable pageable){
		User user = authService.authenticatedUser();
		Page<Notification> pageWithNotifications = notificationRepository.findByUser(user, pageable);
		//após retornar, mapear as páginas de Notification -> NotificationDTO (a Page já é uma Stream)
		return pageWithNotifications.map (notification -> new NotificationDTO(notification));
	}

}
