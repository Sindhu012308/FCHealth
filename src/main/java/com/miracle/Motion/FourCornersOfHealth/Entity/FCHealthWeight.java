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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="FCHEALTH_WEIGHT")
public class FCHealthWeight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	//@ManyToOne(fetch = FetchType.LAZY, targetEntity=PatientProfile.class )
	//@JoinColumn(name="pid", nullable= false)
	@Column(name="PID")
	private Long pid;
	
	@Column(name="W_DATE")
	private Date weightDate;
	
	@Column(name="WEIGHT")
	private Long weight;
	
	@Column(name="DAY")
	private Integer day;
	
	@Column(name="MONTH")
	private Integer month;
	
	@Column(name="YEAR")
	private Integer year;
	
	
	public FCHealthWeight() {
		super();
	}

//	public FCHealthWeight(Long weight) {
//		super();
//		this.weight = weight;
//	}
//	
//	
//	public FCHealthWeight(Long weight, Integer month) {
//		super();
//		this.weight = weight;
//		this.month = month;
//	}
//
	public FCHealthWeight(Long pid, Date weightDate, Long weight, Integer day, Integer month, Integer year) {
		super();
		this.pid = pid;
		this.weightDate = weightDate;
		this.weight = weight;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long personId) {
		this.pid = personId;
	}
	
	public Date getWeightDate() {
		return weightDate;
	}

	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "FCHealthWeight [pid=" + pid + ", weightDate=" + weightDate + ", weight=" + weight + ", day=" + day
				+ ", month=" + month + ", year=" + year + "]";
	}
	
}
