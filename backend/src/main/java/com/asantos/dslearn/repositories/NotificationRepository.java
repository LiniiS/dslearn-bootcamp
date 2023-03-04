package com.asantos.dslearn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.Notification;
import com.asantos.dslearn.entities.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	// JPA vai montar a consulta
	Page<Notification> findByUser(User user, Pageable pageable);

}
