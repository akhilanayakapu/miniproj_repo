package com.akhi.binding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "citizen_plan_details")
public class CitizenPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="cname")
	private String cname;
	private String email;
	private String gender;
	private Integer ssn;
	private String phno;
	@Column(name = "planName")
	private String planName;
	@Column(name = "planStatus")
	private String planStatus;

}
