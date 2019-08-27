package com.miracle.Motion.FourCornersOfHealth.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FCHEALTH_WEIGHT")
public class FCHealthWeight {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID") 
	private long id;
	
	//@ManyToOne(fetch = FetchType.LAZY, targetEntity=PatientProfile.class )
	//@JoinColumn(name="pid", nullable= false)
	@Column(name="PID") 
	private long pid;
	
	@Column(name="W_DATE")
	private Date weightDate;
	
	@Column(name="WEIGHT")
	private long weight;
	
	public FCHealthWeight() {
		super();
	}

	public FCHealthWeight(long weight) {
		super();
		this.weight = weight;
	}

	public FCHealthWeight(long personId, long weight) {
		super();
		this.pid = personId;
		this.weight = weight;
	}
	
	public FCHealthWeight( long weight, Date weightDate) {
		super();
		this.weightDate = weightDate;
		this.weight = weight;
	}

	public FCHealthWeight(long personId, Date date, long weight) {
		super();
		this.pid = personId;
		this.weightDate = date;
		this.weight = weight;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long personId) {
		this.pid = personId;
	}
	
	public Date getWeightDate() {
		return weightDate;
	}

	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "FCHealth_Weight [personId=" + pid + ", date=" + weightDate + ", weight=" + weight + "]";
	}
	
}
