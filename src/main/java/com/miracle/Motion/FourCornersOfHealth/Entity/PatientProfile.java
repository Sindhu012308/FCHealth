package com.miracle.Motion.FourCornersOfHealth.Entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="PATIENT_PROFILE")
public class PatientProfile {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PID")
	private long pid;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "USER_ID"))
	@Column(name="USER_ID")
	private long userId;
	
//	@ManyToOne
//	@JoinColumn(foreignKey = @ForeignKey(name = "USER_ID"))
//	private User user;
	
	@Column(name="RELATION")
	private String relation;
	
	@Column(name="PATIENT_NAME")
	private String patientName;
	
	@Column(name="HEIGHT")
	private long height;
	
	@Column(name="WEIGHT")
	private long weight;
	
	public PatientProfile() {
		super();
	}

	public PatientProfile(String relation, String patientName, long height, long weight) {
		super();
		this.relation = relation;
		this.patientName = patientName;
		this.height = height;
		this.weight = weight;
	}

	public PatientProfile(long userId, String relation, String patientName, long height, long weight) {
		super();
		this.userId = userId;
		this.relation = relation;
		this.patientName = patientName;
		this.height = height;
		this.weight = weight;
	}

	public PatientProfile(long pid, long userId, String relation, String patientName, long height, long weight) {
		super();
		this.pid = pid;
		this.userId = userId;
		this.relation = relation;
		this.patientName = patientName;
		this.height = height;
		this.weight = weight;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "PatientProfile [pid=" + pid + ", userId=" + userId + ", relation=" + relation + ", patientName="
				+ patientName + ", height=" + height + ", weight=" + weight + "]";
	}
	
}
