package com.asantos.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
