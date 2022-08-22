package com.asantos.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
