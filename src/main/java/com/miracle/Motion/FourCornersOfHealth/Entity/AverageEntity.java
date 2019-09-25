package com.miracle.Motion.FourCornersOfHealth.Entity;

public class AverageEntity {

	private Double avgWeight;
	private String avgMonth;

	public AverageEntity() {
		super();
	}

	public AverageEntity(Double avgWeight, String avgMonth) {
		super();
		this.avgWeight = avgWeight;
		this.avgMonth = avgMonth;
	}

	public Double getAvgWeight() {
		return avgWeight;
	}

	public void setAvgWeight(Double avgWeight) {
		this.avgWeight = avgWeight;
	}

	public String getAvgMonth() {
		return avgMonth;
	}

	public void setAvgMonth(String avgMonth) {
		this.avgMonth = avgMonth;
	}

	@Override
	public String toString() {
		return "AverageEntity [avgWeight=" + avgWeight + ", avgMonth=" + avgMonth + "]";
	}

}
