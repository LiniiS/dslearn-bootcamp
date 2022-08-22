package com.asantos.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
