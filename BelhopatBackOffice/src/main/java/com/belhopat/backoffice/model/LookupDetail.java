package com.belhopat.backoffice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class LookupDetail {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JsonIgnore
	private Lookup lookup;

	private String code;

	private String decription;

	public LookupDetail(){
		
	}
	public LookupDetail(Long id, Lookup lookup, String code, String decription) {
		super();
		this.id = id;
		this.lookup = lookup;
		this.code = code;
		this.decription = decription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lookup getLookup() {
		return lookup;
	}

	public void setLookup(Lookup lookup) {
		this.lookup = lookup;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}
	
	@Override
	public String toString() {
		return "Lookup [id=" + id + ", lookup=" + lookup + ", code=" + code + ", decription=" + decription + "]";
	}

}
