package com.miracle.Motion.FourCornersOfHealth.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FCHEALTH_CL")
public class FCHealthCL {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	//@ManyToOne(fetch = FetchType.LAZY, targetEntity=PatientProfile.class)
	//@JoinColumn(name="pid", nullable= false)
	//@Column(name="PID") 
	private long pid;
	
	@Column(name="CL_DATE")
	private Date clDate;
	
	@Column(name="CL")
	private long chLevel;

	public FCHealthCL() {
		super();
	}

	public FCHealthCL(long pid, Date clDate, long chLevel) {
		super();
		this.pid = pid;
		this.clDate = clDate;
		this.chLevel = chLevel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Date getClDate() {
		return clDate;
	}

	public void setClDate(Date clDate) {
		this.clDate = clDate;
	}

	public long getChLevel() {
		return chLevel;
	}

	public void setChLevel(long chLevel) {
		this.chLevel = chLevel;
	}

	@Override
	public String toString() {
		return "FCHealthCL [id=" + id + ", pid=" + pid + ", clDate=" + clDate + ", chLevel=" + chLevel + "]";
	}
	
}
