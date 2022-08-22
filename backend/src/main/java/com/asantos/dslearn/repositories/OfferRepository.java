package com.asantos.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asantos.dslearn.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
