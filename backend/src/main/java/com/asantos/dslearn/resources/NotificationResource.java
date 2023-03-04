package com.asantos.dslearn.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asantos.dslearn.dto.NotificationDTO;
import com.asantos.dslearn.services.NotificationService;

@RestController
@RequestMapping(value="/notifications")
public class NotificationResource {

	@Autowired
	private NotificationService notificationService;
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> getNotificationsForCurrentUser(Pageable pageable){
		Page<NotificationDTO> pageWithNotifications = notificationService.notificationsForCurrentUser(pageable);
		return ResponseEntity.ok().body(pageWithNotifications);
	}
}
