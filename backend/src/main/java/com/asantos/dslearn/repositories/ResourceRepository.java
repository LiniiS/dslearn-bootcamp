package com.asantos.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
