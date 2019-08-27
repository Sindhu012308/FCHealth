package com.miracle.Motion.FourCornersOfHealth.Repos;

public interface CustomFCHRepository {

	long findRecentValueByPid(long patientId, String query);
}
