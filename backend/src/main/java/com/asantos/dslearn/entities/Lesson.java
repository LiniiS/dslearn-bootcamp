package com.asantos.dslearn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED) // decidir os tipos diferentes como uma tabela só ou criar uma tabela
												// pra cada relacionar cm FK
public abstract class Lesson implements Serializable { // garantir a herança total

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer position;

	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;

	// Uma Lesson conhece as várias matrículas que terminaram a aula
	// qnd cada aluno terminou cada lição, muitos pra muitos
	@ManyToMany
	@JoinTable(name = "tb_lessons_done", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = {
			@JoinColumn(name = "user_id"), @JoinColumn(name = "offer_id") })
	private Set<Enrollment> enrollmentsDone = new HashSet<>();

	
	@OneToMany(mappedBy = "lesson")
	private List<Deliver> deliveries = new ArrayList<>();
	
	public Lesson() {
	}

	// não adicionar o Set
	public Lesson(Long id, String title, Integer position, Section section) {
		super();
		this.id = id;
		this.title = title;
		this.position = position;
		this.section = section;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Set<Enrollment> getEnrollmentsDone() {
		return enrollmentsDone;
	}
	
	public List<Deliver> getDeliveries(){
		return deliveries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(id, other.id);
	}

}
