package com.takeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="Course_Details")
@Data
@AllArgsConstructor
public class Course {
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CID")
	@JsonProperty("cid")
	private Integer cid;
	
	@Column(name="CNAME")
	@JsonProperty("cname")
	private String cname;
	
	@Column(name="CDURATION")
	@JsonProperty("cduration")
	private String cduration;
	
	@Column(name="CFEE")
	@JsonProperty("cfee")
	private int cfee;
	

}
