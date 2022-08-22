package com.asantos.dslearn.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.asantos.dslearn.entities.pk.EnrollmentPK;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

	// chave primária de uma classe de associação (muitos pra muitos)
	// nesse caso é preciso instanciar
	// no caso do mapeamentousando a chave composta (via embeddable) usa outra
	// anotação
	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK();

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMoment;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;// usar o wrapper qnd o valor poderá se true, false ou null

	public Enrollment() {
	}

	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	public User getStudent() {
		return id.getUser();
	}

	public void setStudent(User user) {
		id.setUser(user);
	}

	public Offer getOffer() {
		return id.getOffer();
	}

	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}

	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

}
