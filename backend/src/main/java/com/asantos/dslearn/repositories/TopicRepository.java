package com.asantos.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
