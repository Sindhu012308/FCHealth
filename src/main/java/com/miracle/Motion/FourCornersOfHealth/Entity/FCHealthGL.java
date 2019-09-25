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
@Table(name = "FCHEALTH_GL")
public class FCHealthGL {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	//@ManyToOne(fetch = FetchType.LAZY,targetEntity=PatientProfile.class)
	//@JoinColumn(name="pid", nullable= false)
	@Column(name="PID") 
	private long pid;
	
	@Column(name="GL_DATE")
	private Date glDate;
	
	@Column(name="GL")
	private long glucoseLevel;

	public FCHealthGL() {
		super();
	}

	public FCHealthGL(long pid, Date glDate, long glucoseLevel) {
		super();
		this.pid = pid;
		this.glDate = glDate;
		this.glucoseLevel = glucoseLevel;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Date getGlDate() {
		return glDate;
	}

	public void setGlDate(Date glDate) {
		this.glDate = glDate;
	}

	public long getGlucoseLevel() {
		return glucoseLevel;
	}

	public void setGlucoseLevel(long glucoseLevel) {
		this.glucoseLevel = glucoseLevel;
	}

	@Override
	public String toString() {
		return "FCHealth_GL [pid=" + pid + ", glDate=" + glDate + ", glucoseLevel=" + glucoseLevel + "]";
	}
	
}
