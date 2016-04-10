package com.belhopat.backoffice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class City {

	@Id
	@GeneratedValue
	private Long id;
	
	private String code;
	
	private String description;
	
	@ManyToOne
	private State state;

	public City(Long id, String code, String description, State state) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", description=" + description + ", state=" + state + "]";
	}
	
}
