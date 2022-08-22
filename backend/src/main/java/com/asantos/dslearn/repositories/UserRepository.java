package com.asantos.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
