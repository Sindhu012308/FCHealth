package com.miracle.Motion.FourCornersOfHealth.Repos;

import java.util.List;
import java.util.Map;

import com.miracle.Motion.FourCornersOfHealth.Entity.AverageEntity;

public interface CustomFCHRepository {

	long findRecentValueByPid(long patientId, String query);
	
	List<AverageEntity> findAverageValues(long patientId, String query, int year) throws Exception;
}
